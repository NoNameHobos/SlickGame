package main.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Point;

import main.engine.Player;

public abstract class Mob extends Entity {

	protected float health, health_max;
	protected float move_speed;
	protected float speed;
	protected float direction;
	protected float acc;
	protected float phys_def;
	protected float mag_def;
	
	protected Point des;
	
	protected Player player;
	
	public Mob(Player player, float x, float y, Image sprite) {
		super(new Point(x, y), sprite);
		this.player = player;
	}
	
	public void move(float spd, float angle) {
		float sin = (float)Math.sin(Math.toRadians(angle));
		float cos = (float)Math.cos(Math.toRadians(angle));
		pos.setX(pos.getX() + spd * cos);
		pos.setY(pos.getY() + spd * sin);
	}
	
	public void moveTo(Point target) {
		if(getDistanceTo(target) >= 16) {
			direction = getPointDirection(target);
			if(speed < move_speed) speed += acc;
		} else speed = 0;
	}
	
	public float getHealth() {
		return health;
	}

	public void setHealth(float health, boolean rel) {
		if(!rel)
			this.health = health;
		else this.health += health;
	}
	public void setHealth(float health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed, boolean rel) {
		if(!rel)
			this.speed = speed;
		else this.speed += speed;
	}

	public float getAcc() {
		return acc;
	}

	public void setAcc(float acc, boolean rel) {
		if(!rel)
			this.acc = acc;
		else this.acc += acc;
	}

	public float getHealthMax() {
		return health_max;
	}
	public float getMoveSpeed() {
		return move_speed;
	}

	public Player getPlayer() {
		return player;
	}
	
}
