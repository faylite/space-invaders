package tut.baseball435.spaceinvaders.entity;

import tut.baseball435.spaceinvaders.TextureManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity
{
	private final EntityManager entityManager;
	private long lastFire;
	
	public Player( Vector2 pos, Vector2 direction, EntityManager entityManager )
	{
		super( TextureManager.PLAYER, pos, direction );
		this.entityManager = entityManager;
	}
	
	@Override
	public void update()
	{
		pos.add( direction );
		
		// -----------------------------------	 Controls	---------------------------------
		// Left input listener
		if ( Gdx.input.isKeyPressed( Keys.A ) || Gdx.input.isKeyPressed( Keys.LEFT )) {
			setDirection( -300, 0 );
		}
		// Right input listener
		else if ( Gdx.input.isKeyPressed( Keys.D ) || Gdx.input.isKeyPressed( Keys.RIGHT )) {
			setDirection( 300, 0 );
		}
		// Else stop movement
		else {
			setDirection( 0, 0 );
		}
		// Fire missile
		if ( Gdx.input.isKeyPressed( Keys.SPACE ) ) {
			if ( System.currentTimeMillis() - lastFire >= 250 ){
				entityManager.addEntity( new Missile( pos.cpy().add( ( 25 ),
						TextureManager.PLAYER.getHeight() ) ) );
				lastFire = System.currentTimeMillis();
			}
		}
		// -----------------------------------	    End		 ---------------------------------
	}
}
