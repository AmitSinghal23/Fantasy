package org.game.fantasy.quest.display;

import org.game.fantasy.quest.util.GameComponents;

public interface Canvas extends Component{

	public void repaint();
	public Component add(Component component);
	public GameComponents getComponents();
	public void clear();
}
