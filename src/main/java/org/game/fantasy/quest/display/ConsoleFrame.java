package org.game.fantasy.quest.display;

import java.util.ArrayList;
import java.util.List;

public class ConsoleFrame implements Frame{

	List<Component> componentList;
	
	public ConsoleFrame(){
		componentList = new ArrayList<Component>();
	}
	
	@Override
	public void add(Component component) {
		componentList.add(component);
	}

	@Override
	public void show(boolean flag) {
		
		
	}

	@Override
	public void repaint() {
		System.out.println("\n");
		componentList.forEach(i -> i.render());
	}

}
