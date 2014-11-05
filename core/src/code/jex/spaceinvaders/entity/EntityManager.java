package code.jex.spaceinvaders.entity;

import code.jex.spaceinvaders.MainGame;
import code.jex.spaceinvaders.TextureManager;
import code.jex.spaceinvaders.screen.GameOverScreen;
import code.jex.spaceinvaders.screen.ScreenManager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class EntityManager
{
	// Note: Array is imported from LibGDX
	private final Array<Entity> entities = new Array<Entity>();
	private final Player player;
	
	public EntityManager( int amount )
	{
		player = new Player( new Vector2( 220, 15 ), new Vector2( 0, 0 ), this );
		for ( int i = 0; i < amount; i++ ) {
			float x = MathUtils.random( 0, MainGame.WIDTH - TextureManager.ENEMY.getWidth() );
			float y = MathUtils.random( MainGame.HEIGHT, MainGame.HEIGHT * 2 );
			float speed = MathUtils.random( 2, 5 );
			addEntity( new Enemy( new Vector2( x, y ), new Vector2( 0, -speed ) ) );
		}
	}
	
	public void update()
	{
		player.update();
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
		checkCollisions();
	}
	
	public void render( SpriteBatch sb )
	{
		player.render( sb );
		for ( Entity e:entities ) {
			e.render( sb );
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
						ScreenManager.setScreen( new GameOverScreen( true ) );
					}
				}
			}
			if ( e.getBounds().overlaps( player.getBounds() ) ) {
				ScreenManager.setScreen( new GameOverScreen( false ) );
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
}
