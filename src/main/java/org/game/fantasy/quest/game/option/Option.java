package org.game.fantasy.quest.game.option;

public interface Option<T>{
	public int getOptionId();
	public boolean isSelected();
	public T getDescription();
}
