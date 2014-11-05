package code.jex.spaceinvaders.entity;

import code.jex.spaceinvaders.MainGame;
import code.jex.spaceinvaders.TextureManager;

import com.badlogic.gdx.math.Vector2;

public class Missile extends Entity
{
	
	public Missile( Vector2 pos )
	{
		super( TextureManager.MISSILE, pos, new Vector2( 0, 5 ) );
	}
	
	@Override
	public void update()
	{
		pos.add( direction );
	}
	
	public boolean checkEnd()
	{	
		return pos.y >= MainGame.HEIGHT;
	}
	
}
