package org.game.fantasy.quest.game;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.display.Logo;

public class GameLauncher implements Runnable{

	private GameContext context;
	private boolean gameStatus = true;
	
	public GameLauncher(GameContext context){
		this.context = context;
	}
	
	@Override
	public void run() {
		Logo.printLogo();
		
		init();
	}

	private void init() {
		GameEngine gameEngine = new GameEngine(context);
		gameEngine.init();
		gameEngine.start();
		
		gameStatus = false;
	}

	public boolean isGameStatus() {
		return gameStatus;
	}
}
