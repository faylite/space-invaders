package tut.baseball435.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager
{
	public static Texture PLAYER = new Texture( Gdx.files.internal( "player.png" ) );
	public static Texture MISSILE = new Texture( Gdx.files.internal( "missile.png" ) );
	public static Texture ENEMY = new Texture( Gdx.files.internal( "enemy.png" ) );
}
