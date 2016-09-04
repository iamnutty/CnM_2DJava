package dev.codenmore.tilegame.tile;

import dev.codenmore.tilegame.gfx.Assets;

public class waterFallMiddleTile extends Tile {

	public waterFallMiddleTile(int id) {
		super(Assets.waterFallMiddle, id);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public boolean isSolid(){
		return false;
	}	
	
	
	
}
