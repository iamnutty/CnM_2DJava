package dev.codenmore.tilegame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;

public class Player extends Creature{
	
	//Moved below code to creature class so that all creatures become animated for movement
	
	//Animations
	private Animation animDown;
	private Animation animUp;
	private Animation animLeft;
	private Animation animRight;	
	
	//default display state
	private BufferedImage displayState = Assets.player_down[1];;  

	public Player(Handler handler,float x, float y) {
		super(handler, x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 4;
		bounds.y = 2;
		bounds.width= 24;
		bounds.height= 28;
		
		//Animations
		animDown = new Animation(1000/4,Assets.player_down);
		animUp = new Animation(1000/4,Assets.player_up);
		animRight = new Animation(1000/4,Assets.player_right);
		animLeft = new Animation(1000/4,Assets.player_left);
		
	}

	@Override
	public void tick() {
		
		//Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		//Movement
		
		getInput();
		move();	
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up) {
			yMove = -speed;
			//this.displayState = Assets.playerUp;
		}
		if(handler.getKeyManager().down) {
			yMove = +speed;
			//this.displayState = Assets.playerDown;
		}
		if(handler.getKeyManager().left) {
			xMove = -speed;
			//this.displayState = Assets.playerLeft;
		}
		if(handler.getKeyManager().right) {
			xMove = +speed;
			//this.displayState = Assets.playerRight;
		}
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(getCurrentAnimationFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int)( y - handler.getGameCamera().getyOffset()), width, height, null);
		
		
		
		/*
		g.setColor(Color.red);
		g.fillRect((int)((x+ bounds.x-handler.getGameCamera().getxOffset())),
				(int)((y+ bounds.y-handler.getGameCamera().getyOffset())),
				bounds.width,bounds.height);
		*/
		
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove<0){
			displayState = Assets.player_left[1];
			return animLeft.getCurrentFrame();
		}else if(xMove>0){
			displayState = Assets.player_right[1];
			return animRight.getCurrentFrame();
		}else if(yMove<0){
			displayState = Assets.player_up[1];
			return animUp.getCurrentFrame();
		}else if(yMove>0){
			displayState = Assets.player_down[1];
			return animDown.getCurrentFrame();
		}else return displayState;
				
		
		
	}
	

}
