package code.jex.spaceinvaders.screen;

import code.jex.spaceinvaders.HighScoreManager;
import code.jex.spaceinvaders.MainGame;
import code.jex.spaceinvaders.camera.OrthoCamera;
import code.jex.spaceinvaders.entity.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HighScoreScreen extends Screen
{
	private OrthoCamera camera;
	private HighScoreManager hsm;
	
	private BitmapFont scoreTable;
	private BitmapFont newScore;
	private BitmapFont scoresFont;
	private BitmapFont promptFont;
	
	
	private String newScoreMsg;
	private String prompt;
	
	private int score;
	private boolean newHighScore;
	private int waitCounter;
	
	@Override
	public void create()
	{
		camera = new OrthoCamera();
		camera.resize();
		hsm = new HighScoreManager();
		
		scoreTable = new BitmapFont();
		scoreTable.scale( 2 );
		
		newScore = new BitmapFont();
		newScore.setScale( 2 );
		newScore.setColor( Color.YELLOW );
		
		scoresFont = new BitmapFont();
		scoresFont.setScale( 1 );
		
		promptFont = new BitmapFont();
		promptFont.setScale( 2 );
		
		if ( MainGame.TOUCH())
			prompt = "TOUCH screen to restart";
		else
			prompt = "Press ENTER to restart";
		
		newScoreMsg = "New Highscore!";
		score = Player.score;
		newHighScore = hsm.newHighScore(score);
		waitCounter = 0;
	}
	
	@Override
	public void update()
	{
		camera.update();
		if ( waitCounter > 50 ) {
			if ( MainGame.TOUCH() && Gdx.input.isTouched() ) {
				ScreenManager.setScreen( new MainMenuScreen() );
			} else if ( Gdx.input.isKeyPressed( Keys.ENTER ) ) {
				ScreenManager.setScreen( new MainMenuScreen() );
			}
		}
		waitCounter++;
	}
	
	@Override
	public void render( SpriteBatch sb )
	{
		sb.setProjectionMatrix( camera.combined );
		sb.begin();
		scoreTable.draw( sb, "High Scores:",
				MainGame.WIDTH / 2 - scoreTable.getBounds( "High Scores:" ).width / 2,
				MainGame.HEIGHT / 10 * 9 );
		
		if(newHighScore){
			newScore.draw( sb, newScoreMsg, MainGame.WIDTH / 2
					- newScore.getBounds( newScoreMsg ).width / 2, MainGame.HEIGHT / 10 * 8 );
		}
		// Get the width of the text
		float scoresFontWidth = scoresFont.getBounds( hsm.getHighScoreString() ).width / 2;
		// Magic, don't touch!
		scoresFont.drawMultiLine( sb, hsm.getHighScoreString(), MainGame.WIDTH / 2
				- scoresFontWidth, MainGame.HEIGHT / 10 * 7, MainGame.WIDTH - scoresFontWidth / 4,
				HAlignment.CENTER );
		
		promptFont.draw( sb, prompt, MainGame.WIDTH/2 - promptFont.getBounds( prompt ).width/2, MainGame.HEIGHT/10*2 );
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
		scoreTable.dispose();
		scoresFont.dispose();
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
