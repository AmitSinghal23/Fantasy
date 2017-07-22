package org.game.fantasy.quest.game.helper;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.game.challenge.CategoryPrompt.Category;
import org.game.fantasy.quest.game.challenge.Challenge;
import org.game.fantasy.quest.game.challenge.ConsoleChallengePrompt;
import org.game.fantasy.quest.game.challenge.question.ConsoleQuestion;
import org.game.fantasy.quest.game.challenge.question.Level;
import org.game.fantasy.quest.game.challenge.question.Question;
import org.game.fantasy.quest.game.factory.questionfactory.ConsoleQuestionFactory;
import org.game.fantasy.quest.game.factory.questionfactory.QuestionProducer;
import org.game.fantasy.quest.game.menu.ConsoleMenu;
import org.game.fantasy.quest.game.menu.Menu;
import org.game.fantasy.quest.game.option.ConsoleOption;
import org.junit.Before;
import org.junit.Test;

public class GameEngineHelperTest {
	
	GameContext gameContext;
	
	@Before
	public void populateGameContext(){
		gameContext = new GameContext();
	}

	@Test
	public void testGetChallengeCatagory() {
		GameEngineHelperImpl helper = new GameEngineHelperImpl(gameContext);
		Menu<String> menu = helper.getChallengeCatagory();
		assertThat(menu, instanceOf(ConsoleMenu.class));
	}

	@Test
	public void testGetChallengeCatagory_Size() {
		GameEngineHelperImpl helper = new GameEngineHelperImpl(gameContext);
		Menu<String> menu = helper.getChallengeCatagory();
		assertEquals(2, menu.getOptionList().size());
	}

	
	@Test
	public void testGetGameContext() {
		GameEngineHelperImpl helper = new GameEngineHelperImpl(gameContext);
		assertThat(helper.getGameContext(), instanceOf(GameContext.class));
	}

	@Test
	public void testGetChallenge() {
		ConsoleQuestionFactory factory = mock(ConsoleQuestionFactory.class);
		
		List<ConsoleQuestion> questionList = Arrays.asList(
				new ConsoleQuestion(1, "1. How are you going to prove your worth to be the heir of the great throne?", 
						Arrays.asList(new ConsoleOption(1, "1938", false), new ConsoleOption(2, "1939", true)), Level.EASY, Category.HISTORY, false),
				new ConsoleQuestion(2, "2. What does the prophecy of Goddess Mara say about reinvasion of Ronar?", 
						Arrays.asList(new ConsoleOption(1, "1948", true), new ConsoleOption(2, "1950", false)), Level.MEDIUM, Category.HISTORY, true));

		
		when(factory.getQuestionList()).thenReturn(questionList);
		List<? extends Question<String>> list = QuestionProducer.getQuestionListByCategoryLevel(Category.HISTORY);
		Challenge<String> challenge = new ConsoleChallengePrompt(list.get(0), gameContext);
		
		assertEquals("1. How are you going to prove your worth to be the heir of the great throne?", challenge.getChallenge().getQuestion());
		assertEquals(2, challenge.getMenu().getOptionList().size());
	}

	@Test
	public void testGetUserPrompt() {
		GameEngineHelperImpl helper = new GameEngineHelperImpl(gameContext);
		
		Challenge<String> prompt = helper.getUserPrompt();
		assertEquals("Please Type Your Name..", prompt.getChallenge().getQuestion());
		assertEquals(0, prompt.getChallenge().getOptions().size());
	}

	@Test
	public void testGetMenuItem() {
		GameEngineHelperImpl helper = new GameEngineHelperImpl(gameContext);
		Challenge<String> menu = helper.getMenuItem();
		assertEquals("Main Menu..", menu.getChallenge().getQuestion());
				
	}

}
