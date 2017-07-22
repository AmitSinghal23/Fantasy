package org.game.fantasy.quest.game.deligate;

import java.util.Random;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.game.challenge.footer.ConsoleFooter;
import org.game.fantasy.quest.game.challenge.footer.Footer;

public class ResultDeligate implements Deligate{

	GameContext gameContext;
	private String[] SUCCESS = {"You have some substance....now try next..", "Well Done...let's see if you can solve next...", "This was close... but you sailed through", "Looks like today God is also with you..."}; 
	
	public ResultDeligate(GameContext gameContext) {
		this.gameContext = gameContext;
	}

	@Override
	public void run() {
		processInput();
		
	}

	@Override
	public void processInput() {
		Footer footer;
		StringBuilder status = new StringBuilder("");
		try {
			gameContext.getDeligateLatch().await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (gameContext.isSavedStatus()){
			status.append("Game Saved !!");
			footer = new ConsoleFooter(status.toString());
			
			gameContext.setSavedStatus(false);
			gameContext.setFooter(footer);
			
			gameContext.getResultLatch().countDown();
 
			return;
		}
		
		if(!gameContext.isProceed()){
			status.append("You are doomed...not worthy to be the king of Pendora !!");
		} else {
			status.append(SUCCESS[(new Random()).nextInt(4)]);
		}
		
		if(gameContext.isLevelChange() && gameContext.isProceed()){
			status.append("\n");
			status.append("You are learning fast.... moved to next level..Congrats !!");
			gameContext.setLevelChange(false);
		}
		
		if(gameContext.isFinalState() && gameContext.isProceed()){
			status = new StringBuilder("");
			if(gameContext.getCategory().categoryId() == 1){
				status.append("You have liberated Ronar, the QUEST is completed !!");
			}else if(gameContext.getCategory().categoryId() == 2){
				status.append("You have got the map of lost treasures of Ganzala, the QUEST is completed !!");
			}
			
			status.append("\n");
			status.append("Pandora has got it's King....You Won !!");
			gameContext.setProceed(false);
		}
		
		footer = new ConsoleFooter(status.toString());
		
		gameContext.setFooter(footer);
		
		gameContext.getResultLatch().countDown();
	}

}
