package org.game.fantasy.quest.game.menu;

import java.util.List;

import org.game.fantasy.quest.display.Component;
import org.game.fantasy.quest.game.deligate.Deligate;
import org.game.fantasy.quest.game.option.Option;

public interface Menu<T> extends Component{

	public List<Option<T>> getOptionList();
	public void addOption(Option<T> option); 
	public void registerDeligate(Deligate deligate);
	public void setOptionList(List<Option<T>> optionList);
	public void processAction();
}
