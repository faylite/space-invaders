package code.jex.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager
{
	public static Texture PLAYER = new Texture( Gdx.files.internal( "player.png" ) );
	public static Texture MISSILE = new Texture( Gdx.files.internal( "missile.png" ) );
	public static Texture ENEMY = new Texture( Gdx.files.internal( "enemy.png" ) );
	public static Texture EXPLOSION = new Texture(Gdx.files.internal( "animations/explosionframes.png" ));
	
	public static void pause(){
		PLAYER.dispose();
		MISSILE.dispose();
		ENEMY.dispose();
		EXPLOSION.dispose();
	}
	public static void resume(){
		PLAYER = new Texture( Gdx.files.internal( "player.png" ) );
		MISSILE = new Texture( Gdx.files.internal( "missile.png" ) );
		ENEMY = new Texture( Gdx.files.internal( "enemy.png" ) );
		EXPLOSION = new Texture(Gdx.files.internal( "animations/explosionframes.png" ));
	}
}
