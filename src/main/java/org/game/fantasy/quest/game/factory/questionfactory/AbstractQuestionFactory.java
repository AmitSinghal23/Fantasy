package org.game.fantasy.quest.game.factory.questionfactory;

import java.util.List;

public abstract class AbstractQuestionFactory<T> {
	public abstract List<T> getQuestionList();
}
