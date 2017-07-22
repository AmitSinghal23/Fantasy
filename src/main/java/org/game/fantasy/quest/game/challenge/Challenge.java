package org.game.fantasy.quest.game.challenge;

import org.game.fantasy.quest.game.challenge.question.Question;
import org.game.fantasy.quest.game.menu.Menu;

public interface Challenge<T> {

	public Question<T> getChallenge();
	public Menu<T> getMenu();
}
