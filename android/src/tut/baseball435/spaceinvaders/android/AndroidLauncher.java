package tut.baseball435.spaceinvaders.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import tut.baseball435.spaceinvaders.MainGame;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
		
		// For battery saving
		cfg.useAccelerometer = false;
		cfg.useCompass = false;
		// --
		
		initialize(new MainGame(), cfg);
	}
}
