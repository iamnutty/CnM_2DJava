package dev.codenmore.tilegame.worlds;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.EntityManager;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.entities.statics.Tree;
import dev.codenmore.tilegame.tile.Tile;
import dev.codenmore.tilegame.utils.Utils;

public class World {
	
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	
	private int[][] tiles;
	
	//entities
	private EntityManager entityManager;	
	
	
	
	public World(Handler handler, String worldPath,String worldEntitiesPath){
		this.handler = handler;
		
		entityManager = new EntityManager(handler, new Player(handler, 100,100));
		//entityManager.addEntity(new Tree(handler,170,170));
		//entityManager.addEntity(new Tree(handler,64,64));
		//entityManager.addEntity(new Tree(handler,200,50));
		
		loadWorldEntities(worldEntitiesPath);
		
		loadWorldTiles(worldPath);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		
		
	}
	
	public void tick(){
		entityManager.tick();
		
	}
	
	public void render(Graphics g){
		int xStart = (int) Math.max(0, (handler.getGameCamera().getxOffset() / Tile.TILEWIDTH));
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset()+ handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, (handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT));;
		int yEnd = (int) Math.min(width, (handler.getGameCamera().getyOffset()+ handler.getHeight()) / Tile.TILEHEIGHT + 1);;
		
		
		for(int y =yStart;y<yEnd;y++){
			for(int x=xStart;x<xEnd;x++){
				getTile(x,y).render(g, (int) (x*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), 
						(int) (y*Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			
			}
		}
		
		
		//Entities
		entityManager.render(g);
		
	}
	
	public Tile getTile(int x, int y){
		
		if(x < 0 || y < 0 ||x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
			
		//test code
		//System.out.println("tile value: " + tiles[x][y]);
				
		if(t==null)	return Tile.grassTile;
		
		return t;
	}
	
		
	private void loadWorldTiles(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		//width = 5;
		//height = 7;
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]) * Tile.TILEWIDTH;
		spawnY = Utils.parseInt(tokens[3]) * Tile.TILEHEIGHT;
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x<width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x+y*width)+4]);
			}
		}		
		
	}
	
	
	private void loadWorldEntities(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		//int entityCount = Utils.parseInt(tokens[0]);	
		int mapWidth = Utils.parseInt(tokens[0]);
		int mapHeight = Utils.parseInt(tokens[1]);
				
		/*
		
		for(int y = 0;y < (entityCount*3);){		
			entityManager.addEntity(Utils.parseInt(tokens[++y]),Utils.parseInt(tokens[++y]),Utils.parseInt(tokens[++y]));
		}
		
		*/
		int i = 1;
		for(int y = 0;y < mapHeight;y++){
			for(int x = 0;x< mapWidth;x++){
				//tiles[x][y] = Utils.parseInt(tokens[(x+y*width)+4]);
				entityManager.addEntity(Utils.parseInt(tokens[++i]),x*Tile.TILEWIDTH,y*Tile.TILEHEIGHT);
			
			}
		}
		
				
		
	}
	
	
	
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	
	
	//added by Adithya below maybe redundant
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/*
	
	public int getSpawnX() {
		return spawnX;
	}

	public void setSpawnX(int spawnX) {
		this.spawnX = spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}

	public void setSpawnY(int spawnY) {
		this.spawnY = spawnY;
	}
	
	*/
	
	
	
	
	
}
