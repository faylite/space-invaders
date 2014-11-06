package code.jex.spaceinvaders.screen;

import code.jex.spaceinvaders.MainGame;
import code.jex.spaceinvaders.SoundManager;
import code.jex.spaceinvaders.TextureManager;
import code.jex.spaceinvaders.camera.OrthoCamera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenuScreen extends Screen
{
	private OrthoCamera camera;
	
	private BitmapFont titleFont;
	private BitmapFont promptFont;
	
	private String title = "Space Invaders!";
	private String prompt;
	
	private int waitCounter;
	
	@Override
	public void create()
	{
		TextureManager.resume();
		SoundManager.resume();
		
		camera = new OrthoCamera();
		camera.resize();
		
		// Fonts and text initializers
		titleFont = new BitmapFont();
		titleFont.scale( 3 );
		if(MainGame.TOUCH())
			prompt = "Touch screen to start!";
		else
			prompt = "Press ENTER to start!";
		
		promptFont = new BitmapFont();
		promptFont.setScale( 1 );
		
		// Start music
		SoundManager.MUS_BACKGROUND.setLooping( true );
		SoundManager.MUS_BACKGROUND.play();
		
		waitCounter = 0;
	}
	
	@Override
	public void update()
	{
		if (waitCounter > 50){
			if(MainGame.TOUCH()){
				if (Gdx.input.isTouched()){
					ScreenManager.setScreen( new GameScreen() );
				}
			} else {
				if(Gdx.input.isKeyPressed( Keys.ENTER )){
					ScreenManager.setScreen( new GameScreen() );
				}
			}
		}
		waitCounter++;
	}
	
	@Override
	public void render( SpriteBatch sb )
	{
		sb.setProjectionMatrix( camera.combined );
		sb.begin();
		titleFont.draw( sb, title, MainGame.WIDTH/2 - getStringWidth(titleFont,title)/2, MainGame.HEIGHT/4 * 3 );
		promptFont.draw( sb, prompt, MainGame.WIDTH/2 - getStringWidth(promptFont,prompt)/2, MainGame.HEIGHT/2 );
		sb.end();
	}
	
	private int getStringWidth(BitmapFont bmpf , String str){
		return (int)bmpf.getBounds( str ).width;
	}
	
	@Override
	public void resize( int width, int height )
	{
		
	}
	
	@Override
	public void dispose()
	{
		titleFont.dispose();
		promptFont.dispose();
	}
	
	@Override
	public void pause()
	{
		TextureManager.pause();
		SoundManager.pause();
	}
	
	@Override
	public void resume()
	{	
		create();
	}
	
}
