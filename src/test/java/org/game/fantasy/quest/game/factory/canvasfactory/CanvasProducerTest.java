package org.game.fantasy.quest.game.factory.canvasfactory;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.game.fantasy.quest.display.ConsoleCanvas;
import org.game.fantasy.quest.game.factory.canvasfactory.CanvasProducer.CanvasType;
import org.junit.Test;

public class CanvasProducerTest {

	@Test
	public void testGetCanvas() {
		assertThat(CanvasProducer.getCanvas(CanvasType.CONSOLE), instanceOf(ConsoleCanvas.class));
	}

}
