package dev.codenmore.tilegame;
//testing merge
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.GameCamera;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.input.MouseManager;
import dev.codenmore.tilegame.states.GameState;
import dev.codenmore.tilegame.states.MenuState;
import dev.codenmore.tilegame.states.State;

public class Game implements Runnable {
	
	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//private BufferedImage testImage;
	//private SpriteSheet sheet;
	
	//States can change to private later
	public State gameState;
	public State menuState;
	
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	
	
	public Game(String title, int width, int height){		
		this.width = width;
		this.height = height;
		this.title = title;	
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	private void init(){
		display = new Display(title,width,height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		
		// adding redundant listener to ensure smooth operation
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0,0);
		
		
		
		//test
		//testImage = ImageLoader.loadImage("/textures/T_Balls.png");
		//sheet = new SpriteSheet(testImage);
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(menuState);
	}
	
	// Temp code 
		//int x = 0;
	
	private void tick(){
		keyManager.tick();
		
		if(State.getState()!=null){
			State.getState().tick();
		}
		//x++;
	
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		//Clear Screen or set screen background to 
		g.fillRect(0, 0, width, height);
		// Draw Here!
		
		if(State.getState()!=null){
			State.getState().render(g);
		}
		
		
		
		//g.drawImage(Assets.grass, x, 10, null);
		//Test
		//g.drawImage(sheet.crop(32, 0, 32, 32), 0, 0, null);
		//g.drawImage(sheet.crop(160, 0, 160, 160), 50, 50, null);
				
		//End Drawing!
		bs.show();
		g.dispose();
		
	}
	
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime(); //sys time in nano sec
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick(); // to normalise between processor speed
				render();
				ticks++;
				delta--;
			}
			
			
			// Optional fps printer
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();		
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}


	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	
	public MouseManager getMouseManager(){
		return mouseManager;
	}
	
	public synchronized void  start(){
		
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	
	

}
