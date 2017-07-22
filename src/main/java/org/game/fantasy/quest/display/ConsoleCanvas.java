package org.game.fantasy.quest.display;

import org.game.fantasy.quest.util.GameComponents;

public class ConsoleCanvas implements Canvas{
	
	GameComponents gameComponents;
	
	public ConsoleCanvas() {
		this.gameComponents = new GameComponents();
	}

	@Override
	public Component add(Component component) {
		gameComponents.add(component);
		return component;
	}

	@Override
	public void render() {
		gameComponents.render();
	}

	@Override
	public void repaint() {
		
		
	}

	@Override
	public void clear() {
		this.gameComponents = new GameComponents();
		
	}

	@Override
	public GameComponents getComponents() {
		return gameComponents;
	}

	public void setGameComponents(GameComponents gameComponents) {
		this.gameComponents = gameComponents;
	}
	
}
