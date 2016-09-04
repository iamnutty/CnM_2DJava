package dev.codenmore.tilegame.tile;

import dev.codenmore.tilegame.gfx.Assets;

public class waterFallRightTile extends Tile {

	public waterFallRightTile(int id) {
		super(Assets.waterFallRight, id);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public boolean isSolid(){
		return false;
	}	
	
	
	
}
