package tut.baseball435.spaceinvaders.entity;

import tut.baseball435.spaceinvaders.MainGame;
import tut.baseball435.spaceinvaders.TextureManager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class EntityManager
{
	// Note: Array is imported from LibGDX
	private final Array<Entity> entities = new Array<Entity>();
	private final Player player;
	
	public EntityManager( int amount )
	{
		player = new Player( new Vector2( 220, 15 ), new Vector2( 0, 0 ) );
		for ( int i = 0; i < amount; i++ ) {
			float x = MathUtils.random( 0, MainGame.WIDTH - TextureManager.ENEMY.getWidth() );
			float y = MathUtils.random( MainGame.HEIGHT, MainGame.HEIGHT * 2 );
			float speed = MathUtils.random( 2, 5 );
			addEntity( new Enemy( new Vector2( x, y ), new Vector2( 0, -speed ) ) );
		}
	}
	
	public void update()
	{
		player.update();
		for ( Entity e:entities ) {
			e.update();
		}
	}
	
	public void render( SpriteBatch sb )
	{
		player.render( sb );
		for ( Entity e:entities ) {
			e.render( sb );
		}
	}
	
	public void addEntity( Entity entity )
	{
		entities.add( entity );
	}
}
