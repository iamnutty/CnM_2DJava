package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.worlds.World;

public class GameState extends State{
	
	//private Player player;
	private World world;
	
	
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.txt","res/worlds/world1entities.txt");
		handler.setWorld(world);
		
		// Earlier The below code had 0,0 in place of Get Spawn X and Get Spawn Y 
		
		//player = new Player(handler, world.getSpawnX(), world.getSpawnY());
		
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		world.tick();
		//player.tick();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
				
		//Tile.tiles[0].render(g,0,0);
		//Tile.tiles[1].render(g,0,0);
		//Tile.tiles[2].render(g,0,0);
		//Tile.tiles[3].render(g,0,0);
		world.render(g);
		//player.render(g);
		
		
		//g.drawImage(Assets.player, 0, 0, null);
			
	
	}
	
	
	
	

}
