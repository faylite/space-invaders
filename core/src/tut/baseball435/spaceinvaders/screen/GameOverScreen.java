package tut.baseball435.spaceinvaders.screen;

import tut.baseball435.spaceinvaders.MainGame;
import tut.baseball435.spaceinvaders.TextureManager;
import tut.baseball435.spaceinvaders.camera.OrthoCamera;

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
	
	private String prompt;
	
	public GameOverScreen(boolean won){
		if (won){
			texture = TextureManager.GAME_WON;
		} else {
			texture = TextureManager.GAME_OVER;
		}	
	}
	@Override
	public void create()
	{
		font = new BitmapFont();
		camera = new OrthoCamera();
		camera.resize();
		
		if (MainGame.TOUCH()){
			prompt = "Touch to exit";
		} else {
			prompt = "Press ENTER to exit";
		}
	}
	
	@Override
	public void update()
	{
		camera.update();
		if (Gdx.input.isTouched()){
			exit();
		}
		else if (Gdx.input.isKeyPressed(Keys.ENTER)){
			exit();
		}
	}
	
	@Override
	public void render( SpriteBatch sb )
	{
		sb.setProjectionMatrix( camera.combined );
		sb.begin();
		sb.draw(texture, MainGame.WIDTH/2 - texture.getWidth()/2, MainGame.HEIGHT/2 - texture.getHeight()/2);
		font.draw( sb, prompt, MainGame.WIDTH/2 - font.getBounds( prompt ).width/2 , MainGame.HEIGHT/4);
		sb.end();
	}
	
	@Override
	public void resize( int width, int height )
	{
		camera.resize();
	}
	private void exit(){
		Gdx.app.exit();
	}
	
	@Override
	public void dispose()
	{
		
	}
	
	@Override
	public void pause()
	{	
		
	}
	
	@Override
	public void resume()
	{	
		
	}
}
