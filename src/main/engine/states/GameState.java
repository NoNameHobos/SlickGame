package main.engine.states;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import main.engine.State;
import main.entities.Entity;
import main.entities.Mob;
import main.entities.military.Golem;

public class GameState extends State {

	private ArrayList<Mob> mobs = new ArrayList<Mob>();
	
	public GameState(String name) {
		super(name);
	}

	//Main Step Event for Game State
	public void tick() {
		//Update Entities
		ArrayList<Entity> entities = Entity.getEntities();
		for(int j = 0; j < entities.size(); j++) {
			entities.get(j).pollEntity();
		}
	}

	//Render the Game State
	public void render(Graphics g) {
		g.setBackground(new Color(50, 50, 50));
		g.setColor(Color.white);
		//Render Entities
		ArrayList<Entity> entities = Entity.getEntities();
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).render(g);
		}
	}

}
