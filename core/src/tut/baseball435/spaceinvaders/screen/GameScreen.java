package tut.baseball435.spaceinvaders.screen;

import tut.baseball435.spaceinvaders.camera.OrthoCamera;
import tut.baseball435.spaceinvaders.entity.Player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends Screen
{
	private OrthoCamera camera;
	private Player player;
	
	@Override
	public void create()
	{
		// Initiate
		camera = new OrthoCamera();
		player = new Player( new Vector2( 220, 15 ), new Vector2( 0, 0 ) );
	}
	
	@Override
	public void update()
	{
		camera.update();
		player.update();
	}
	
	@Override
	public void render( SpriteBatch sb )
	{
		sb.setProjectionMatrix( camera.combined );
		sb.begin();
		player.render( sb );
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
		
	}
	
	@Override
	public void resume()
	{	
		
	}
}
