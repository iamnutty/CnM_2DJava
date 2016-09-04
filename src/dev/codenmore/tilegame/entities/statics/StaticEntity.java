package dev.codenmore.tilegame.entities.statics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;
import dev.codenmore.tilegame.tile.Tile;

public abstract class StaticEntity extends Entity {
	
	//STATIC STUFF
	public static StaticEntity[] staticEntities = new StaticEntity[256];
	//public static staticEntities[0] = Tree;

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	

}
