package org.game.fantasy.quest.util;

import java.util.ArrayList;
import java.util.List;

import org.game.fantasy.quest.display.Component;

public class GameComponents {
	
	List<Component> gameComponents;
	
	public GameComponents() {
		init();
	}

	private void init() {
		this.gameComponents = new ArrayList<Component>();
	}

	public void add(Component component){
		gameComponents.add(component);
	}
	
	public List<Component> get(){
		return gameComponents;
	}
	
	public void render(){
		gameComponents.forEach(i -> i.render());
	}
}
