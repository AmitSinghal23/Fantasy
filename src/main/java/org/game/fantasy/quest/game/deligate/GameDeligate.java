package org.game.fantasy.quest.game.deligate;

import java.util.function.Predicate;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.game.challenge.question.Question;
import org.game.fantasy.quest.game.option.Option;
import org.game.fantasy.quest.util.ConsoleReader;
import org.game.fantasy.quest.util.marshaller.Marshaller;
import org.game.fantasy.quest.util.marshaller.StandardJavaMarshaller;

public class GameDeligate implements Deligate{

	private static final Predicate<String> IN_RANGE = text -> text.equals("1") || text.equals("2")|| text.equals("9");
	int result;

	GameContext gameContext;
	Question<? extends Object> question;
	
	public GameDeligate(GameContext gameContext, Question<? extends Object> question) {
		this.gameContext = gameContext;
		this.question = question;
	}

	private final Runnable redrawWithWarningMessage = () -> {
		System.out.println("Enter valid input .. ");
	};

	@Override
	public void processInput() {
		ConsoleReader reader = new ConsoleReader();
		result = reader.readIntegerUntil(IN_RANGE, redrawWithWarningMessage);
		validate();
		gameContext.getDeligateLatch().countDown();
	}
	
	private void validate(){
		String path = System.getProperty("quest.file");
		if(path == null){
			gameContext.getDeligateLatch().countDown();
			gameContext.setProceed(false);
			throw new IllegalArgumentException("Please specify quest.file property while starting new game !!");
		}
		int correctAnswer = question.getOptions().stream().filter(i -> i.isSelected()).mapToInt(i -> i.getOptionId())
				.findFirst().getAsInt();		
		if (result == correctAnswer){
			gameContext.setIndex(gameContext.getIndex()+1);
		} else if(result == 9){
			Marshaller marshaller = new StandardJavaMarshaller();
			marshaller.marshall(gameContext, path);
			gameContext.setSavedStatus(true);;
		}else {
			gameContext.setProceed(false);
		}
		
		if(question.isFinalQuestion() && result == correctAnswer){
			gameContext.setFinalState(true);
		}
		
		if(question.getLevel() != gameContext.getLevel()){
			gameContext.setLevelChange(true);
			gameContext.setLevel(question.getLevel());
		}
	}

	@Override
	public void run() {
		processInput();
	}
	
}
