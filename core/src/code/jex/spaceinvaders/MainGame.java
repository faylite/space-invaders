package code.jex.spaceinvaders;

import code.jex.spaceinvaders.screen.MainMenuScreen;
import code.jex.spaceinvaders.screen.ScreenManager;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends ApplicationAdapter
{
	// Dev options ---------------------------
	// Remember to enable music and disable god mode before pushing to master :P
	public static boolean MUSIC = true;
	public static boolean INIFNITE_ENEMIES = true;// NOTE: True is now default.
	public static boolean GOD_MODE = false;// OMG-Mode
	public static int FIRE_RATE = 200;// Delay in milliseconds between shots.
	
	public static int ENEMIES = 50;
	/*
	 * Amount of enemies that will be on-screen at the same time,
	 * Keeps enemy amount to this when INIFINITE_ENEMIES is true.
	 */
	
	public static int ENEMY_SPEED = 1;// Enemy speed modifier multiplied by a number between 2,5
	// ------------------------------------------
	
	// Game window screen width and height
	public static int WIDTH = 480, HEIGHT = 800;
	
	// Returns true if the platform is not desktops
	// TODO: Maybe add individual checks for each platform. (Not req.)
	public static boolean TOUCH()
	{
		String t = Gdx.app.getType().toString();
		if ( t == "Desktop" ) {
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
		Gdx.gl.glClearColor( 0, 0, 0, 0 );
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
