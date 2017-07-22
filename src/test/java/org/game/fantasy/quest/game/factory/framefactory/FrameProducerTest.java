package org.game.fantasy.quest.game.factory.framefactory;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.game.fantasy.quest.display.ConsoleFrame;
import org.game.fantasy.quest.game.factory.framefactory.FrameProducer.FrameType;
import org.junit.Test;

public class FrameProducerTest {

	@Test
	public void testGetFrame() {
		assertThat(FrameProducer.getFrame(FrameType.CONSOLE), instanceOf(ConsoleFrame.class));
	}
}
