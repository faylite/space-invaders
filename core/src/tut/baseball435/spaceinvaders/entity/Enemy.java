package tut.baseball435.spaceinvaders.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends Entity
{

	public Enemy( Texture texture, Vector2 pos, Vector2 direction )
	{
		super( texture, pos, direction );
	}

	@Override
	public void update()
	{
		pos.add( direction );
	}
	
}
