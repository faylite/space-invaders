package code.jex.spaceinvaders.screen;

import code.jex.spaceinvaders.MainGame;
import code.jex.spaceinvaders.camera.OrthoCamera;
import code.jex.spaceinvaders.entity.EntityManager;
import code.jex.spaceinvaders.entity.Player;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends Screen
{
	private OrthoCamera camera;
	private EntityManager entityManager;
	
	private BitmapFont scoreFont;
	
	@Override
	public void create()
	{
		// Initiate
		camera = new OrthoCamera();
		camera.resize();
		entityManager = new EntityManager(40);
		scoreFont = new BitmapFont();
		scoreFont.setColor( Color.CYAN );
		scoreFont.setScale( 2 );
	}
	
	@Override
	public void update()
	{
		camera.update();
		entityManager.update();
	}
	
	@Override
	public void render( SpriteBatch sb )
	{
		String score = String.valueOf( Player.score );
		sb.setProjectionMatrix( camera.combined );
		sb.begin();
		entityManager.render( sb );
		scoreFont.draw( sb, "Score: "+score, MainGame.WIDTH - scoreFont.getBounds( "Score: 1"+Player.score ).width, MainGame.HEIGHT);
		sb.end();
	}
	
	@Override
	public void resize( int width, int height )
	{
		camera.resize();
	}
	
	@Override
	public void dispose()
	{	
		
	}
	
	@Override
	public void pause()
	{
		ScreenManager.setScreen( new MainMenuScreen() );
	}
	
	@Override
	public void resume()
	{
		
	}
}
