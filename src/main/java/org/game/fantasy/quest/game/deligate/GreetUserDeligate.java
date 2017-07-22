package org.game.fantasy.quest.game.deligate;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.game.challenge.footer.ConsoleFooter;
import org.game.fantasy.quest.game.challenge.footer.Footer;

public class GreetUserDeligate implements Deligate {
	GameContext gameContext;
	
	public GreetUserDeligate(GameContext gameContext) {
		this.gameContext = gameContext;
	}

	@Override
	public void run() {
		processInput();
		
	}

	@Override
	public void processInput() {
		Footer footer;
		try {
			gameContext.getDeligateLatch().await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(gameContext.getPlayer() != null){
			footer = new ConsoleFooter("Welcome "+gameContext.getPlayer().getName());
		} else {
			footer = new ConsoleFooter("Welcome Unknown User....");
		}
		
		gameContext.setFooter(footer);
		
		gameContext.getResultLatch().countDown();
	}
}
