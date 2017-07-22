package org.game.fantasy.quest.game.challenge;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.game.challenge.question.Question;
import org.game.fantasy.quest.game.deligate.GameDeligate;
import org.game.fantasy.quest.game.deligate.ResultDeligate;
import org.game.fantasy.quest.game.menu.ConsoleMenu;
import org.game.fantasy.quest.game.menu.Menu;

public class ConsoleChallengePrompt implements Challenge<String>{

	private Question<String> question;
	private Menu<String> menu;

	public ConsoleChallengePrompt(Question<String> question, GameContext gameContext){
		this.question = question;
		
		initMenu(question, gameContext);
	}

	private void initMenu(Question<String> question, GameContext gameContext) {
		menu = new ConsoleMenu();
		menu.setOptionList(question.getOptions());
		menu.registerDeligate(new GameDeligate(gameContext, question));
		menu.registerDeligate(new ResultDeligate(gameContext));
	}
	
	@Override
	public Question<String> getChallenge() {
		return question;
	}
	
	public Question<String> getQuestion() {
		return question;
	}

	public void setQuestion(Question<String> question) {
		this.question = question;
	}

	@Override
	public Menu<String> getMenu() {
		return menu;
	}

	public void setMenu(Menu<String> menu) {
		this.menu = menu;
	}
}
