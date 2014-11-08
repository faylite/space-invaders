package code.jex.spaceinvaders.entity;

import code.jex.spaceinvaders.TextureManager;
import code.jex.spaceinvaders.util.KeyHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity
{
	private final EntityManager entityManager;
	private final KeyHandler inputHandler;
	
	// Player info
	public static int score = 0;
	public static String NAME = "Player";
	public final static int MOVEMENT_SPEED = 300;
	
	protected String platform;
	
	public Player( Vector2 pos, Vector2 direction, EntityManager entityManager )
	{
		super( TextureManager.PLAYER, pos, direction );
		
		// Initialize
		this.entityManager = entityManager;
		score = 0;
		inputHandler = new KeyHandler( this, this.entityManager );
		
		platform = Gdx.app.getType().toString();
	}
	
	@Override
	public void update()
	{
		pos.add( direction );
		
		inputHandler.listenForInput();
	}
	public Vector2 getPlayerPostion()
	{
		return this.pos;
	}
}
