package dev.codenmore.tilegame.display;

import java.awt.Canvas; // this is to paint inside
import java.awt.Dimension;

import javax.swing.JFrame; //this is a window

// class to create a new window frame

public class Display {
	
	private JFrame frame;
	private Canvas canvas;
	
	
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
		
	}
	
	private void createDisplay(){
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setFocusable(false);
		
		
		frame.add(canvas); //add canvas to frame
		frame.pack(); // pack the canvas inside frame size
		
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	
}
