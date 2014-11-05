package code.jex.spaceinvaders.desktop;

import code.jex.spaceinvaders.MainGame;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher
{
	public static void main( String[] arg )
	{
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		// Window configuration
		cfg.title = "SpaceInvaders";
		cfg.addIcon( "icon/16x16.png", FileType.Internal);
		cfg.addIcon( "icon/32x32.png", FileType.Internal);
		cfg.addIcon( "icon/128x128.png", FileType.Internal);
		cfg.width = MainGame.WIDTH;
		cfg.height = MainGame.HEIGHT;
		
		new LwjglApplication( new MainGame(), cfg );
	}
}
