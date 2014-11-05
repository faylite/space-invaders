package code.jex.spaceinvaders.screen;

import code.jex.spaceinvaders.camera.OrthoCamera;
import code.jex.spaceinvaders.entity.EntityManager;
import code.jex.spaceinvaders.entity.Player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends Screen
{
	private OrthoCamera camera;
	private EntityManager entityManager;
	
	@Override
	public void create()
	{
		// Initiate
		camera = new OrthoCamera();
		entityManager = new EntityManager(10);
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
		sb.setProjectionMatrix( camera.combined );
		sb.begin();
		entityManager.render( sb );
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
