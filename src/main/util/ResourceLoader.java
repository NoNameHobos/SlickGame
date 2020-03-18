package main.util;

import java.util.HashMap;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class ResourceLoader {

	public static HashMap<String, Image> SPRITES = new HashMap<String, Image>();
	public static HashMap<String, SpriteSheet> SPRITE_SHEETS = new HashMap<String, SpriteSheet>();
	public static HashMap<String, Animation> ANIMATIONS = new HashMap<String, Animation>();
	
	public static Animation loadAnimation(String dir, int duration) {
		
	}
	
	public static Animation loadAnimation(SpriteSheet ss, int duration) {
		
	}
	
	public static Image loadImage(String dir) {
		Image i;
		try {
			i = new Image(dir + ".png");
			return i;
		} catch(SlickException e) {
			System.err.println("Failed to load image at: " + dir);
			e.printStackTrace();
			return null;
		}
	}
	/*
	public static Image loadImage(String dir, String name) {
		Image i;
		try {
			i = new Image(dir + name + ".png");
			SPRITES.put(name, i);
			return i;
		} catch(SlickException e) {
			System.err.println("Failed to load image at: " + dir);
			e.printStackTrace();
			return null;
		}
	}
	*/

	public static Image loadImageFromSS(SpriteSheet ss, int x, int y) {
		ss.startUse();
		Image i = ss.getSprite(x, y);
		ss.endUse();
		return i;
	}
	
	public static SpriteSheet loadSpriteSheet(String dir, int tw, int th) {
		SpriteSheet ss;
		try {
			ss = new SpriteSheet(dir + ".png", tw, th);
			return ss;
		} catch(SlickException e) {
			System.err.println("Failed to load Sprite Sheet at: " + dir);
			e.printStackTrace();
			return null;
		}
	}
	
	public static void initResources() {
		//LOAD GOLEM SPRITE
		SPRITES.put("spr_golem", loadImage("res/mobs/Golem"));
	}
	
}
