package org.game.fantasy.quest.game.display;

import static org.mockito.Mockito.mock;

import org.game.fantasy.quest.display.Component;
import org.game.fantasy.quest.display.ConsoleCanvas;
import org.game.fantasy.quest.util.GameComponents;
import org.junit.Test;

public class CanvasTest {

	@Test
	public void testAdd() {
		ConsoleCanvas canvas = new ConsoleCanvas();
		Component component = mock(Component.class);
		canvas.add(component);
	}

	@Test
	public void testSetGameComponents() {
		ConsoleCanvas canvas = new ConsoleCanvas();
		GameComponents gameComponents = mock(GameComponents.class);
		canvas.setGameComponents(gameComponents);
	}

}
