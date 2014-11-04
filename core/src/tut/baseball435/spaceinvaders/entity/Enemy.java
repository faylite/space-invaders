package tut.baseball435.spaceinvaders.entity;

import tut.baseball435.spaceinvaders.TextureManager;

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
	}
	
}
