package code.jex.spaceinvaders;

import code.jex.spaceinvaders.screen.MainMenuScreen;
import code.jex.spaceinvaders.screen.ScreenManager;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends ApplicationAdapter
{
	// Dev options
	public static boolean MUSIC = false;
	public static boolean INIFNITE_ENEMIES = true;
	public static boolean GOD_MODE = false;
	
	public static int WIDTH = 480, HEIGHT = 800;
	
	public static boolean TOUCH(){
		String t = Gdx.app.getType().toString();
		if ( t == "Desktop" ){
			return false;
		} else {
			return true;
		}
	}
	SpriteBatch batch;
	
	@Override
	public void create()
	{
		batch = new SpriteBatch();
		ScreenManager.setScreen( new MainMenuScreen() );
	}
	@Override
	public void dispose()
	{
		if ( ScreenManager.getCurrentScreen() != null ) {
			ScreenManager.getCurrentScreen().dispose();
		}
		batch.dispose();
	}
	@Override
	public void render()
	{
		Gdx.gl.glClearColor( 0, 0, 0, 1 );
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
		
		if ( ScreenManager.getCurrentScreen() != null ) {
			ScreenManager.getCurrentScreen().update();
			ScreenManager.getCurrentScreen().render( batch );
		}
	}
	@Override
	public void resize( int width, int height )
	{
		if ( ScreenManager.getCurrentScreen() != null ) {
			ScreenManager.getCurrentScreen().resize( width, height );
		}
	}
	@Override
	public void pause()
	{
		if ( ScreenManager.getCurrentScreen() != null ) {
			ScreenManager.getCurrentScreen().pause();
		}
	}
	@Override
	public void resume()
	{
		if ( ScreenManager.getCurrentScreen() != null ) {
			ScreenManager.getCurrentScreen().resume();
		}
	}
}
