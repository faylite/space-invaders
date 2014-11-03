package tut.baseball435.spaceinvaders;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends ApplicationAdapter
{
	public static int WIDTH = 480, HEIGHT = 800;
	
	SpriteBatch batch;
	
	@Override
	public void create()
	{
		batch = new SpriteBatch();
	}
	@Override
	public void dispose()
	{
		batch.dispose();
	}
	@Override
	public void render()
	{
		Gdx.gl.glClearColor( 1, 0, 0, 1 );
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
		
		batch.begin();
		
		batch.end();
	}
	@Override
	public void resize( int width, int height )
	{
		super.resize( width, height );
	}
	@Override
	public void pause()
	{
		super.pause();
	}
	@Override
	public void resume()
	{
		super.resume();
	}
}
