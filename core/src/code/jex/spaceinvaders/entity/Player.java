package code.jex.spaceinvaders.entity;

import code.jex.spaceinvaders.InputHandler;
import code.jex.spaceinvaders.TextureManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity
{
	private final EntityManager entityManager;
	private final InputHandler inputHandler;
	
	public final int movementSpeed = 300;
	
	protected String platform;
	
	
	public Player( Vector2 pos, Vector2 direction, EntityManager entityManager )
	{
		super( TextureManager.PLAYER, pos, direction );
		
		// Initialize
		this.entityManager = entityManager;
		inputHandler = new InputHandler(this , this.entityManager);
		
		platform = Gdx.app.getType().toString();
	}
	
	@Override
	public void update()
	{
		pos.add( direction );
		
		inputHandler.listenForInput();
	}
	public Vector2 getPlayerPostion(){
		return this.pos;
	}
}
