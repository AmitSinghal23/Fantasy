package org.game.fantasy.quest.game.display;

import static org.mockito.Mockito.mock;

import org.game.fantasy.quest.display.Component;
import org.game.fantasy.quest.display.ConsoleFrame;
import org.junit.Test;

public class FrameTest {

	@Test
	public void testAdd() {
		ConsoleFrame frame = new ConsoleFrame();
		Component component = mock(Component.class);
		
		frame.add(component);
	}

}
