package code.jex.spaceinvaders.screen;

import code.jex.spaceinvaders.camera.OrthoCamera;
import code.jex.spaceinvaders.entity.EntityManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends Screen
{
	private OrthoCamera camera;
	private EntityManager entityManager;
	
	// Load music
	private Music backMusic;
	
	@Override
	public void create()
	{
		// Initiate
		camera = new OrthoCamera();
		entityManager = new EntityManager(50);
		
		// Initiate music and start playing
		backMusic = Gdx.audio.newMusic( Gdx.files.internal( "sound/background_music.mp3" ) );
		backMusic.play();
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
