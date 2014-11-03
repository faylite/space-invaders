package tut.baseball435.spaceinvaders.screen;

import tut.baseball435.spaceinvaders.camera.OrthoCamera;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuScreen extends Screen
{
	private OrthoCamera camera;
	
	@Override
	public void create()
	{
		camera = new OrthoCamera();
	}
	
	@Override
	public void update()
	{
		camera.update();
	}
	
	@Override
	public void render( SpriteBatch sb )
	{	
		
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
		
	}
	
	@Override
	public void resume()
	{	
		
	}
}
