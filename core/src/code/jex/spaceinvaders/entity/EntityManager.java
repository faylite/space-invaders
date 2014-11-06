package code.jex.spaceinvaders.entity;

import code.jex.spaceinvaders.MainGame;
import code.jex.spaceinvaders.TextureManager;
import code.jex.spaceinvaders.screen.GameOverScreen;
import code.jex.spaceinvaders.screen.ScreenManager;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class EntityManager
{
	// Note: Array is imported from LibGDX
	private final Array<Entity> entities = new Array<Entity>();
	private final Player player;
	
	// Game state
	private boolean wonGame;
	private boolean gameOver;
	private float gameOverWaitCounter;
	
	// Game Over message
	private BitmapFont gameOverMsg;
	private final String gameOverMsgStr = "Game Over";
	
	public EntityManager( int amount )
	{
		addEntity(player = new Player( new Vector2( 220, 15 ), new Vector2( 0, 0 ), this ));
		for ( int i = 0; i < amount; i++ ) {
			float x = MathUtils.random( 0, MainGame.WIDTH - TextureManager.ENEMY.getWidth() );
			float y = MathUtils.random( MainGame.HEIGHT, MainGame.HEIGHT * 2 );
			float speed = MathUtils.random( 2, 5 );
			addEntity( new Enemy( new Vector2( x, y ), new Vector2( 0, -speed ) ) );
		}
		gameOverMsg = new BitmapFont();
		gameOverMsg.setScale( 4 );
	}
	
	public void update()
	{
		if(!gameOver)
			player.update();
		
		// Render entities
		for ( Entity e:entities ) {
			e.update();
		}
		for ( Missile m:getMissiles() ) {
			if ( m.checkEnd() ) {
				entities.removeValue( m, false );
			}
		}
		for ( Explosion e:getExplosions() ) {
			if (e.getFinished()){
				entities.removeValue( e, false );
			}
		}
		// ----
		checkCollisions();
		
		// Game over renders
		if (gameOver) {
			// Try to end game if wait time is over
			gameOverWaitCounter++;
			tryEndGame();
		}
	}
	
	public void render( SpriteBatch sb )
	{
		for ( Entity e:entities ) {
			e.render( sb );
		}
		if (gameOver){
			int i = 0;
			i = (int)gameOverMsg.getBounds( gameOverMsgStr ).width;
			gameOverMsg.draw( sb, gameOverMsgStr , MainGame.WIDTH/2 - i/2 , MainGame.HEIGHT/4 * 3 );
		}
	}
	
	private void checkCollisions()
	{
		for ( Enemy e:getEnemies() ) {
			for ( Missile m:getMissiles() ) {
				if ( e.getBounds().overlaps( m.getBounds() ) ) {
					addEntity( new Explosion( new Vector2( e.pos.x, e.pos.y ), new Vector2( 0, 0 ) ) );
					entities.removeValue( e, false );
					entities.removeValue( m, false );
					if ( gameOver() ) {
						endGame(true);
					}
				}
			}
			if ( e.getBounds().overlaps( player.getBounds() ) && !gameOver) {
				addEntity( new Explosion(new Vector2(player.pos.x , player.pos.y) , new Vector2(0,0)));
				entities.removeValue( player, true );
				
				endGame(false);
			}
		}
	}
	
	public void addEntity( Entity entity )
	{
		entities.add( entity );
	}
	
	private Array<Enemy> getEnemies()
	{
		Array<Enemy> ret = new Array<Enemy>();
		for ( Entity e:entities ) {
			if ( e instanceof Enemy ) {
				ret.add( (Enemy) e );
			}
		}
		return ret;
	}
	
	private Array<Missile> getMissiles()
	{
		Array<Missile> ret = new Array<Missile>();
		for ( Entity e:entities ) {
			if ( e instanceof Missile ) {
				ret.add( (Missile) e );
			}
		}
		return ret;
	}
	private Array<Explosion> getExplosions()
	{
		Array<Explosion> ret = new Array<Explosion>();
		for ( Entity e:entities ) {
			if ( e instanceof Explosion ) {
				ret.add( (Explosion) e );
			}
		}
		return ret;
	}
	
	public boolean gameOver()
	{
		return getEnemies().size <= 0;
	}
	private void endGame(boolean win){
		wonGame = win;
		gameOver = true;
		gameOverWaitCounter = 0;
	}
	private void tryEndGame(){
		if (gameOverWaitCounter > 600){
			ScreenManager.setScreen( new GameOverScreen(wonGame) );
		}
	}
}
