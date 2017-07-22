package org.game.fantasy.quest.game.challenge.question;

import java.util.List;

import org.game.fantasy.quest.display.Component;
import org.game.fantasy.quest.game.option.Option;

public interface Question<T> extends Component{

	public T getQuestion();
	public List<Option<T>> getOptions();
	public boolean isFinalQuestion();
	public Level getLevel();
	
}
