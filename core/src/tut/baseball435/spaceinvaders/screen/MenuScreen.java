package tut.baseball435.spaceinvaders.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuScreen extends Screen
{
	
	@Override
	public void create()
	{
		System.out.println( "Created" );
	}
	
	@Override
	public void render( SpriteBatch sb )
	{
		System.out.println("Render");
	}

	@Override
	public void resize( int width, int height )
	{
		System.out.println("Resize");
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