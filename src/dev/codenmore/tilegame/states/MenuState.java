package dev.codenmore.tilegame.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;

public class MenuState extends State {
	
	public MenuState(Handler handler){
		super(handler);
		
	}
	

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		System.out.println(handler.getMouseManager().getMouseX() + "  " + handler.getMouseManager().getMouseY());
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed())
			State.setState(handler.getGame().gameState);
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.ORANGE);
		g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
		
	}

}
