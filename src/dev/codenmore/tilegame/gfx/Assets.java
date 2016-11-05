package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	//public static BufferedImage playerDown,playerUp,playerLeft, playerRight;
	public static BufferedImage grass,dirt,stone,tree,tree1,thicket,thicket2,waterFallLeft,waterFallRight,waterFallMiddle;
	
	
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_right;
	public static BufferedImage[] player_left;	
	public static BufferedImage[] btn_start;
	
	public static void init(){
		
		SpriteSheet sheet = new SpriteSheet (ImageLoader.loadImage("/textures/Char1_400.png"));
		
		
		
		
		player_down = new BufferedImage[4];
		player_down[0] = sheet.crop(0, 0, width, height);
		player_down[1] = sheet.crop(width, 0, width, height);
		player_down[2] = sheet.crop(width*2, 0, width, height);
		player_down[3] = sheet.crop(width, 0, width, height);
		
		
		player_left = new BufferedImage[4];
		player_left[0] = sheet.crop(0, height, width, height);
		player_left[1] = sheet.crop(width, height, width, height);
		player_left[2] = sheet.crop(width*2, height, width, height);
		player_left[3] = sheet.crop(width, height, width, height);
		
		player_right = new BufferedImage[4];
		player_right[0] = sheet.crop(0, height*2, width, height);
		player_right[1] = sheet.crop(width, height*2, width, height);
		player_right[2] = sheet.crop(width*2, height*2, width, height);
		player_right[3] = sheet.crop(width, height*2, width, height);
		
		player_up = new BufferedImage[4];
		player_up[0] = sheet.crop(0, height*3, width, height);
		player_up[1] = sheet.crop(width, height*3, width, height);
		player_up[2] = sheet.crop(width*2, height*3, width, height);
		player_up[3] = sheet.crop(width, height*3, width, height);
		
		
		
		//playerDown = sheet.crop(0, 0, width, height);
		//playerLeft = sheet.crop(0, height, width, height);
		//playerRight = sheet.crop(0, height * 2, width, height);
		//playerUp = sheet.crop(0, height * 3, width, height);
		
		SpriteSheet sheet1 = new SpriteSheet (ImageLoader.loadImage("/textures/Mega_World_Tile_1.png"));
		
		//need to change this start button later to actual image
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet1.crop(48*3+16, 16*7, 48, 48);;
		btn_start[1] = sheet1.crop(48*3+16, 16*7+48, 48, 48);
		
				
		dirt = sheet1.crop(48*3+16+48+32, 16*7, 48, 48);
		grass = sheet1.crop(48*3+16, 16*7, 48, 48);
		stone = sheet1.crop(48*3+16, 16*7+48, 48, 48);
		tree = sheet1.crop(48*3+16+16+16+32, 16*7-48-8, 48, 56);
		thicket = sheet1.crop(48*3+16+48+32+48+32, 16*10+32, 48, 48);
		
		
		//grass = sheet1.crop(48*3+16+48+32+48+32+48, 16*10+32, 32, 32);
		
	
		
		grass = sheet1.crop(0, 16*7, 48, 48);
		grass = sheet1.crop(0, 16*7+48, 48, 48);
		grass = sheet1.crop(0, 16*7+96, 48, 48);
		waterFallLeft = sheet1.crop(0, 16*7+48*11, 48, 48);
		waterFallRight = sheet1.crop(48, 16*7+48*11, 48, 48);
		waterFallMiddle = sheet1.crop(24, 16*7+48*11, 48, 48);
	}
	
}
