package org.game.fantasy.quest.game.deligate;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.context.Player;
import org.game.fantasy.quest.util.ConsoleReader;

public class UserDeligate implements Deligate{

	GameContext gameContext;

	public UserDeligate(GameContext gameContext) {
		this.gameContext = gameContext;
	}
	
	@Override
	public void run() {
		processInput();
	}

	@Override
	public void processInput() {
		ConsoleReader reader = new ConsoleReader();
		String userName = "";
		userName = reader.readString();
		
		Player player = new Player(userName);
		gameContext.setPlayer(player);
		
		gameContext.getDeligateLatch().countDown();
	}

}
