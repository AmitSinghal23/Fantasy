package org.game.fantasy.quest.game.challenge;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.game.deligate.CategoryDeligate;
import org.game.fantasy.quest.game.deligate.CategoryResultDeligate;
import org.game.fantasy.quest.game.deligate.ResultDeligate;
import org.game.fantasy.quest.game.menu.ConsoleMenu;
import org.game.fantasy.quest.game.menu.Menu;
import org.game.fantasy.quest.game.option.ConsoleOption;
import org.game.fantasy.quest.game.option.Option;

public class CategoryPrompt{

	Menu menu;
	
	public CategoryPrompt(GameContext gameContext){
		menu = new ConsoleMenu();
		menu.registerDeligate(new CategoryDeligate(gameContext));
		menu.registerDeligate(new CategoryResultDeligate(gameContext));
		init();	
	}
	
	public void init() {
		
		Category[] values = Category.values();
		for (Category value : values){
			Option<String> option = new ConsoleOption(value.gameCategoryId, value.category(), false);
			menu.addOption(option);
		}
	}
	
	public enum Category{
		HISTORY(1, "Liberate the lost city of Ronar.."),
		SCIENCE(2, "Search for the lost treasure of Ganzala..");
		
		private int gameCategoryId;
		private String gameCategory;
		
		Category(int gameCategoryId, String gameCategory){
			this.gameCategoryId = gameCategoryId;
			this.gameCategory = gameCategory;
		}
		
		public String category(){
			return gameCategory;
		}
		
		public int categoryId(){
			return gameCategoryId;
		}
	}

	public Menu getMenu() {
		return menu;
	}
}
