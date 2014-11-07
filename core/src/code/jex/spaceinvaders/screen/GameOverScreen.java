package code.jex.spaceinvaders.screen;

import code.jex.spaceinvaders.MainGame;
import code.jex.spaceinvaders.TextureManager;
import code.jex.spaceinvaders.camera.OrthoCamera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverScreen extends Screen
{
	private OrthoCamera camera;
	private Texture texture;
	private BitmapFont font;
	private BitmapFont font2;
	
	private String prompt;
	private String gameOverMessage;
	
	private int waitCounter;
	
	public GameOverScreen(  )
	{
		
	}
	@Override
	public void create()
	{
		font = new BitmapFont();
		font2 = new BitmapFont();
		font2.setScale( 2 );
		camera = new OrthoCamera();
		camera.resize();
		
		if ( MainGame.TOUCH() ) {
			prompt = "Touch to restart";
		} else {
			prompt = "Press ENTER to restart";
		}
		gameOverMessage = "Game Over!";
		
		waitCounter = 0;
	}
	@Override
	public void update()
	{
		camera.update();
		if(waitCounter > 50){
			if ( MainGame.TOUCH() && Gdx.input.isTouched() ) {
				ScreenManager.setScreen( new HighScoreScreen() );
			} else if ( Gdx.input.isKeyPressed( Keys.ENTER ) ) {
				ScreenManager.setScreen( new HighScoreScreen() );
			}
		}
		waitCounter++;
	}
	@Override
	public void render( SpriteBatch sb )
	{
		sb.setProjectionMatrix( camera.combined );
		sb.begin();
		font.draw( sb, prompt, MainGame.WIDTH / 2 - font.getBounds( prompt ).width / 2,
				MainGame.HEIGHT / 4 );
		font2.draw( sb, gameOverMessage, MainGame.WIDTH / 2 - font2.getBounds( gameOverMessage ).width / 2,
				MainGame.HEIGHT / 4 * 3 );
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
		font.dispose();
	}
	
	@Override
	public void pause()
	{
		
	}
	
	@Override
	public void resume()
	{	
		ScreenManager.setScreen( new MainMenuScreen() );
	}
}
