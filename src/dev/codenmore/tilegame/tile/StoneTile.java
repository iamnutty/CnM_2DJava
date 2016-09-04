package dev.codenmore.tilegame.tile;

import dev.codenmore.tilegame.gfx.Assets;

public class StoneTile extends Tile {

	public StoneTile(int id) {
		super(Assets.stone, id);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public boolean isSolid(){
		return true;
	}	
	
	
	
}
