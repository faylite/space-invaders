package tut.baseball435.spaceinvaders.desktop;

import tut.baseball435.spaceinvaders.MainGame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher
{
	public static void main( String[] arg )
	{
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		// Window configuration
		cfg.title = "SpaceInvaders";
		cfg.width = MainGame.WIDTH;
		cfg.height = MainGame.HEIGHT;
		
		new LwjglApplication( new MainGame(), cfg );
	}
}
