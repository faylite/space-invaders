package code.jex.spaceinvaders.android;

import android.os.Bundle;
import code.jex.spaceinvaders.MainGame;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication
{
	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
		
		initialize( new MainGame(), cfg );
	}
}
