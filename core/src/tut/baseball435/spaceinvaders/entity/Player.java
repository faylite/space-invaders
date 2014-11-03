package tut.baseball435.spaceinvaders.entity;

import tut.baseball435.spaceinvaders.TextureManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity
{
	
	public Player( Texture texture, Vector2 pos, Vector2 direction )
	{
		super( TextureManager.PLAYER, pos, direction );
	}
	
	@Override
	public void update()
	{
		direction.scl( Gdx.graphics.getDeltaTime() );
		pos.add( direction );
	}
	
}
