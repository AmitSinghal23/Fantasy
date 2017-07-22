package org.game.fantasy.quest.game.factory.canvasfactory;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.game.fantasy.quest.display.ConsoleCanvas;
import org.junit.Test;

public class ConsoleCanvasFactoryTest {

	@Test
	public void testGetCanvas() {
		ConsoleCanvasFactory factory = ConsoleCanvasFactory.getInstance();
		assertThat(factory.getCanvas(), instanceOf(ConsoleCanvas.class));
	}

}
