package org.game.fantasy.quest.game.helper;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.game.challenge.Challenge;
import org.game.fantasy.quest.game.menu.Menu;
import org.game.fantasy.quest.game.story.Story;

public interface GameEngineHelper<T> {

	public GameContext getGameContext();
	public Menu<T> getChallengeCatagory();
	public Challenge<T> getChallenge();
	public Challenge<T> getUserPrompt();
	public Story<? extends Object> getStory();
	public Challenge<String> getMenuItem();
}
