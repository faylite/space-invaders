package code.jex.spaceinvaders;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class HighScoreManager
{
	Preferences highscores;
	
	public HighScoreManager()
	{
		highscores = Gdx.app.getPreferences( "highscores" );
		
		/**
		 * Default score-board so the player has something to beat, 
		 * uses the Preferences with an indexer inserted after entry because it was easiest
		 */
		if ( !highscores.getBoolean( "setDefaults" ) ) {
			highscores.putBoolean( "setDefaults", true );
			
			String[] defaultNames = { "JeX", "Captain Murica", "Brave Toaster", "1nv4dur", "Johnny" };
			int[] defaultScores = { 1000, 850, 500, 250, 100 };
			for ( int i = 0; i < 5; i++ ) {
				System.out.println( "Wrote to name" + i + " content: " + defaultNames[i] );
				highscores.putString( "name" + i, defaultNames[i] );
				System.out.println( "Wrote to score" + i + " content: " + defaultScores[i] );
				highscores.putInteger( "score" + i, defaultScores[i] );
				highscores.flush();
			}
		}
	}
	public ArrayList<String> getHighScores()
	{
		ArrayList<String> ret = new ArrayList<String>();
		for ( int i = 0; i < 5; i++ ) {
			ret.add( highscores.getString( "name" + i ) );
			ret.add( highscores.getString( "score" + i ) );
		}
		return ret;
	}
	// Check if new high-score was gotten
	public void postNewHighScore( String name, int score )
	{
		boolean newHighScore = false;
		int place = 0;
		
		for ( int i = 0; i < 5; i++ ) {
			if ( highscores.getInteger( "score" + i ) < score && !newHighScore ) {
				newHighScore = true;
				place = i;
			}
		}
		if ( newHighScore )
			postNewHighScore( name, score, place );
	}
	private void postNewHighScore( String name, int score, int place )
	{
		// Push scores down a notch
		for ( int i = 5; i > place; i-- ) {
			if(i!=0){
				highscores.putString( "name" + i, highscores.getString( "name" + ( i - 1 ) ) );
				highscores.putInteger( "score" + i, highscores.getInteger( "score" + ( i - 1 ) ) );
			}
		}
		highscores.putString( "name" + place, name );
		highscores.putInteger("score" + place, score );
		
		highscores.flush();
	}
	public void clearScores()
	{
		for(int i = 0; i < 5; i++){
			highscores.putString("name"+i, "----");
			highscores.putInteger( "score"+i, 0 );
		}
	}
	public String getHighScoreString()
	{
		String builder = "";
		for ( int i = 0; i < 5; i++ ) {
			builder += highscores.getString( "name" + i ) + "\n";
			builder += highscores.getInteger( "score" + i ) + "\n\n";
		}
		return builder;
	}
}
