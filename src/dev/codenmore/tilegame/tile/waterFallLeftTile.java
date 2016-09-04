package dev.codenmore.tilegame.tile;

import dev.codenmore.tilegame.gfx.Assets;

public class waterFallLeftTile extends Tile {

	public waterFallLeftTile(int id) {
		super(Assets.waterFallLeft, id);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public boolean isSolid(){
		return false;
	}	
	
	
	
}
