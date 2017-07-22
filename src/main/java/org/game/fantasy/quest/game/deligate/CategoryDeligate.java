package org.game.fantasy.quest.game.deligate;

import java.util.function.Predicate;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.game.challenge.CategoryPrompt.Category;
import org.game.fantasy.quest.game.challenge.question.Level;
import org.game.fantasy.quest.util.ConsoleReader;

public class CategoryDeligate implements Deligate {

	private static final Predicate<String> IN_RANGE = text -> text.equals("1") || text.equals("2");
	int result;
	
	GameContext gameContext;

	public CategoryDeligate(GameContext gameContext) {
		this.gameContext = gameContext;
	}

	private final Runnable redrawWithWarningMessage = () -> {
		System.out.println("Enter valid input .. ");
	};

	@Override
	public void processInput() {
		ConsoleReader reader = new ConsoleReader();
		result = reader.readIntegerUntil(IN_RANGE, redrawWithWarningMessage);
		
		setCategory();
		setInitialLevel(); //setting initial level to EASY
		
		gameContext.getDeligateLatch().countDown();
	}

	private void setCategory() {
		Category[] values = Category.values();
		for (Category value : values){
			if(value.categoryId() == result){
				gameContext.setCategory(value);
			}
		}
	}
	
	private void setInitialLevel(){
		gameContext.setLevel(Level.EASY);
	}

	@Override
	public void run() {
		processInput();
	}

}
