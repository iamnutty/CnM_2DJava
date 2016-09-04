package dev.codenmore.tilegame.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {
	
	private BufferedImage[] images;
	private ClickListener clicker;

	public UIImageButton(float x, float y, int width, int height) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		if(hovering)
			g.drawImage(images[1], (int) x, (int) y, width, height, null);
		else
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
		
	}

	@Override
	public void onClick() {
		clicker.onClick();
		
		
	}
	

}
