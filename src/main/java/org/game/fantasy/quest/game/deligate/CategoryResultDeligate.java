package org.game.fantasy.quest.game.deligate;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.game.challenge.footer.ConsoleFooter;
import org.game.fantasy.quest.game.challenge.footer.Footer;

public class CategoryResultDeligate implements Deligate{
	GameContext gameContext;
	
	public CategoryResultDeligate(GameContext gameContext) {
		this.gameContext = gameContext;
	}

	@Override
	public void run() {
		processInput();
		
	}

	@Override
	public void processInput() {
		Footer footer;
		StringBuilder output = new StringBuilder("");
		try {
			gameContext.getDeligateLatch().await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(gameContext.getCategory() != null){
			composeOutput(output);
			footer = new ConsoleFooter(output.toString());
			
		} else {
			footer = new ConsoleFooter("Starting New Quest..");
		}
		
		gameContext.setFooter(footer);
		
		gameContext.getResultLatch().countDown();
	}

	private void composeOutput(StringBuilder output) {
		int numberOfQuestions = 0;
		if(gameContext.getCategory().categoryId() == 1){
			numberOfQuestions = 15;
		} else {
			numberOfQuestions = 8;
		}
		
		output.append("You are brave to choose '"+gameContext.getCategory().category()+"'");
		output.append("\n");
		output.append("As part of this quest you will be asked " +numberOfQuestions +" questons.");
		output.append("\n");
		output.append("Use your knowledge and answer these questions, but remember one wrong answer and you are doomed....");
		output.append("\n");
		output.append("As you will answer the questions, you will gain the trust and move ahead to next altar (level)");
		output.append("\n");
		output.append("May God be with you on this QUEST...");
		output.append("\n");
		output.append("\n");
		output.append("Here comes your first challenge...");

	
	}
	

}
