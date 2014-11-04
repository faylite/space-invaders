package tut.baseball435.spaceinvaders.entity;

import tut.baseball435.spaceinvaders.MainGame;
import tut.baseball435.spaceinvaders.TextureManager;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends Entity
{

	public Enemy( Vector2 pos, Vector2 direction )
	{
		super( TextureManager.ENEMY, pos, direction );
	}

	@Override
	public void update()
	{
		pos.add( direction );
		
		if (pos.y <= -TextureManager.ENEMY.getHeight()){
			float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.ENEMY.getWidth());
			pos.set(x, MainGame.HEIGHT);
		}
	}
	
}
