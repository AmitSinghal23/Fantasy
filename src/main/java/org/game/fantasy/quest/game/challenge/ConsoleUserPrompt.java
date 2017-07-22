package org.game.fantasy.quest.game.challenge;

import java.util.Collections;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.game.challenge.question.ConsoleQuestion;
import org.game.fantasy.quest.game.challenge.question.Level;
import org.game.fantasy.quest.game.challenge.question.Question;
import org.game.fantasy.quest.game.deligate.GreetUserDeligate;
import org.game.fantasy.quest.game.deligate.ResultDeligate;
import org.game.fantasy.quest.game.deligate.UserDeligate;
import org.game.fantasy.quest.game.menu.ConsoleMenu;
import org.game.fantasy.quest.game.menu.Menu;

public class ConsoleUserPrompt implements Challenge<String>{

	private Question<String> question;
	private Menu<String> menu;

	public ConsoleUserPrompt(GameContext gameContext){
		initMenu(question, gameContext);
	}

	private void initMenu(Question<String> question, GameContext gameContext) {
		this.question = new ConsoleQuestion(1, "Please Type Your Name..", Collections.emptyList(), null, null, false);
		menu = new ConsoleMenu();
		menu.registerDeligate(new UserDeligate(gameContext));
		menu.registerDeligate(new GreetUserDeligate(gameContext));
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
