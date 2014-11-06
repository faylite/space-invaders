package code.jex.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundManager
{
	// Music
	public static Music MUS_BACKGROUND = Gdx.audio.newMusic( Gdx.files.internal( "sound/background_music.mp3" ) );
	
	// Sound effects
	public static Sound SFX_EXPLOSION = Gdx.audio.newSound( Gdx.files.internal( "sound/sfxExplosion.wav" ) );
}
