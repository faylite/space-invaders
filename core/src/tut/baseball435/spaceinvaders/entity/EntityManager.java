package tut.baseball435.spaceinvaders.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class EntityManager
{
	// Note: Array is imported from LibGDX
	private final Array<Entity> entities = new Array<Entity>();
	
	public EntityManager()
	{	
		
	}
	
	public void update()
	{
		for (Entity e : entities){
			e.update();
		}
	}
	
	public void render( SpriteBatch sb )
	{	
		for (Entity e : entities){
			e.render( sb );
		}
	}
	
	public void addEntity( Entity entity){
		entities.add( entity );
	}
}
