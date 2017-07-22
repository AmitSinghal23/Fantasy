package org.game.fantasy.quest.game.helper;

import java.util.List;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.game.challenge.Challenge;
import org.game.fantasy.quest.game.challenge.CategoryPrompt;
import org.game.fantasy.quest.game.challenge.ConsoleChallengePrompt;
import org.game.fantasy.quest.game.challenge.ConsoleUserPrompt;
import org.game.fantasy.quest.game.challenge.MainMenuPrompt;
import org.game.fantasy.quest.game.challenge.question.ConsoleQuestion;
import org.game.fantasy.quest.game.challenge.question.Question;
import org.game.fantasy.quest.game.factory.questionfactory.QuestionProducer;
import org.game.fantasy.quest.game.factory.storyfactory.StoryProducer;
import org.game.fantasy.quest.game.factory.storyfactory.StoryProducer.StoryType;
import org.game.fantasy.quest.game.menu.Menu;
import org.game.fantasy.quest.game.story.Story;

public class GameEngineHelperImpl implements GameEngineHelper<String>{

	GameContext gameContext;
	
	public GameEngineHelperImpl(GameContext gameContext){
		this.gameContext = gameContext;
	}
	
	@Override
	public Menu<String> getChallengeCatagory(){
		return new CategoryPrompt(gameContext).getMenu();
	}

	@Override
	public GameContext getGameContext() {
		return gameContext;
	}
	
	@Override
	public Challenge<String> getChallenge(){
		List<? extends Question<String>> questionList = QuestionProducer.getQuestionListByCategoryLevel(gameContext.getCategory());
		
		int currentIndex = gameContext.getIndex();
		Challenge<String> challenge = new ConsoleChallengePrompt(questionList.get(currentIndex), gameContext);
		
		return challenge;
	}

	@Override
	public Challenge<String> getUserPrompt() {
		return new ConsoleUserPrompt(gameContext);
	}

	@Override
	public Story<? extends Object> getStory() {
		
		return StoryProducer.getStory(StoryType.CONSOLE, gameContext);
	}
	
	@Override
	public Challenge<String> getMenuItem(){
		return new MainMenuPrompt(gameContext);
	}
}
