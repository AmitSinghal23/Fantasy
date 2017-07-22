package org.game.fantasy.quest.game.challenge;

import java.util.Collections;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.game.challenge.CategoryPrompt.Category;
import org.game.fantasy.quest.game.challenge.question.ConsoleQuestion;
import org.game.fantasy.quest.game.challenge.question.Question;
import org.game.fantasy.quest.game.deligate.GreetUserDeligate;
import org.game.fantasy.quest.game.deligate.MainMenuDeligate;
import org.game.fantasy.quest.game.deligate.MenuResultDeligate;
import org.game.fantasy.quest.game.deligate.UserDeligate;
import org.game.fantasy.quest.game.menu.ConsoleMenu;
import org.game.fantasy.quest.game.menu.Menu;
import org.game.fantasy.quest.game.option.ConsoleOption;
import org.game.fantasy.quest.game.option.Option;

public class MainMenuPrompt implements Challenge<String>{
	private Question<String> question;
	private Menu<String> menu;

	public MainMenuPrompt(GameContext gameContext){
		initMenu(question, gameContext);
	}

	private void initMenu(Question<String> question, GameContext gameContext) {
		this.question = new ConsoleQuestion(1, "Main Menu..", Collections.emptyList(), null, null, false);
		menu = new ConsoleMenu();
		menu.registerDeligate(new MainMenuDeligate(gameContext));
		menu.registerDeligate(new MenuResultDeligate(gameContext));
		
		init();
	}

	public void init() {
		
		MenuItem[] values = MenuItem.values();
		for (MenuItem value : values){
			Option<String> option = new ConsoleOption(value.id, value.description(), false);
			menu.addOption(option);
		}
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
	
	public enum MenuItem{
		NEW(1, "Start a new Quest.."),
		LOAD(2, "Embark on existing Quest..");
		
		private int id;
		private String description;
		
		MenuItem(int id, String description){
			this.id = id;
			this.description = description;
		}
		
		public String description(){
			return description;
		}
		
		public int id(){
			return id;
		}
	}
}
