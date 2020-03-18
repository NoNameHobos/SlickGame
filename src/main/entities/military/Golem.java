package main.entities.military;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import static main.engine.Engine.ENGINE;
import static main.util.ResourceLoader.SPRITES;
import main.engine.Player;
import main.entities.Mob;

public class Golem extends Mob {

	private final static String ANIM_DIR = "res/mobs/golemwalk_ss.png";
		
	private SpriteSheet walk_ss = new SpriteSheet(ANIM_DIR, 32, 32);
	
	private Animation walk;
	
	public Golem(Player player, float x, float y) {
		super(player, x, y, SPRITES.get("golem"));
		
		//Init Stats
		health = 80;
		move_speed = 1.5f;
		direction = 120;
		acc = 0.1f;
		phys_def = 12;
		mag_def = 9;
		health_max = health;
		walk = new Animation(walk_ss, 100);
		walk.setLooping(true);
		
	}
	//Render/Draw event for the Golem
	public void render(Graphics g) {
		walk.getCurrentFrame().setRotation(direction);
		if(speed != 0) {
			walk.getCurrentFrame().setRotation(direction);
			walk.draw(pos.getX(), pos.getY());
		}
		sprite.setRotation(direction);
		sprite.draw(pos.getX(), pos.getY());
		//g.drawString(Float.toString(getPointDirection(ENGINE.getMouse().getPos())), pos.getX(), pos.getY() - 30);
	}
	
	//Tick/Step event for the Golem
	public void tick() {
		moveTo(ENGINE.getMouse().getPos());
		move(speed, direction);
	}
}
