package code.jex.spaceinvaders.screen;

import java.util.ArrayList;

import code.jex.spaceinvaders.HighScoreManager;
import code.jex.spaceinvaders.MainGame;
import code.jex.spaceinvaders.camera.OrthoCamera;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HighScoreScreen extends Screen
{
	private OrthoCamera camera;
	private HighScoreManager hsm;
	
	private BitmapFont scoreTable;
	private BitmapFont scoresFont;
	
	private ArrayList<String> highScoreList;
	
	@Override
	public void create()
	{
		camera = new OrthoCamera();
		camera.resize();
		hsm = new HighScoreManager();
		
		scoreTable = new BitmapFont();
		scoreTable.scale( 2 );
		
		scoresFont = new BitmapFont();
		scoresFont.setScale( 1 );
	}
	
	@Override
	public void update()
	{
		camera.update();
	}
	
	@Override
	public void render( SpriteBatch sb )
	{
		sb.setProjectionMatrix( camera.combined );
		sb.begin();
		scoreTable.draw( sb, "High Scores:",
				MainGame.WIDTH / 2 - scoreTable.getBounds( "High Scores:" ).width / 2,
				MainGame.HEIGHT / 8 * 7 );
		float posY = MainGame.HEIGHT / 8 * 6;
		scoresFont.drawMultiLine( sb, hsm.getHighScoreString(), MainGame.WIDTH/2 - scoresFont.getBounds( hsm.getHighScoreString() ).width/2, posY );
		sb.end();
	}
	
	@Override
	public void resize( int width, int height )
	{	
		
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
