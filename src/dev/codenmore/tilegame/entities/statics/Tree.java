package dev.codenmore.tilegame.entities.statics;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.tile.Tile;

public class Tree extends StaticEntity{
	
	
	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		/*Original
		bounds.x = width/4;
		bounds.y = Tile.TILEHEIGHT;
		bounds.width = width/2;
		bounds.height = height/2;
		*/
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = width;
		bounds.height = height;
		
		
		
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int)( y - handler.getGameCamera().getyOffset()), width,height,null);
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void collisionAction(){
		this.handler.getWorld().getEntityManager().removeEntity(this);
		return;
	}
	
	

}
