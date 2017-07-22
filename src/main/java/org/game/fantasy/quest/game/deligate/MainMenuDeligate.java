package org.game.fantasy.quest.game.deligate;

import java.util.function.Predicate;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.util.ConsoleReader;
import org.game.fantasy.quest.util.marshaller.Marshaller;
import org.game.fantasy.quest.util.marshaller.StandardJavaMarshaller;

public class MainMenuDeligate implements Deligate{
	GameContext gameContext;
	
	private static final Predicate<String> IN_RANGE = text -> text.equals("1") || text.equals("2");
	int result;

	public MainMenuDeligate(GameContext gameContext) {
		this.gameContext = gameContext;
	}

	private final Runnable redrawWithWarningMessage = () -> {
		System.out.println("Enter valid input .. ");
	};
	
	@Override
	public void run() {
		processInput();
	}

	@Override
	public void processInput() {
		String path = System.getProperty("quest.file");
		if(path == null){
			gameContext.getDeligateLatch().countDown();
			gameContext.setProceed(false);
			throw new IllegalArgumentException("Please specify quest.file property while starting new game !!");
		}
		ConsoleReader reader = new ConsoleReader();
		result = reader.readIntegerUntil(IN_RANGE, redrawWithWarningMessage);
		
		if(result == 2){
			Marshaller marshaller = new StandardJavaMarshaller();
			GameContext loadedGameContext = marshaller.unmarshall(path);
			
			gameContext.getDeligateLatch().countDown();
			copy(loadedGameContext);
		}else {
			gameContext.getDeligateLatch().countDown();
		}
		
	}
	
	private void copy(GameContext context){
		gameContext.setCategory(context.getCategory());
		gameContext.setFinalState(context.isFinalState());
		gameContext.setFooter(context.getFooter());
		gameContext.setIndex(context.getIndex());
		gameContext.setLevel(context.getLevel());
		gameContext.setLevelChange(context.isLevelChange());
		gameContext.setPlayer(context.getPlayer());
		gameContext.setProceed(context.isProceed());
	}
}
