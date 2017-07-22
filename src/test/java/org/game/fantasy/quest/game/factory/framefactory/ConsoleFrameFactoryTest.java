package org.game.fantasy.quest.game.factory.framefactory;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.game.fantasy.quest.display.ConsoleFrame;
import org.junit.Test;

public class ConsoleFrameFactoryTest {
	
	@Test
	public void testGetFrame() {
		ConsoleFrameFactory factory = ConsoleFrameFactory.getInstance();
		assertThat(factory.getFrame(), instanceOf(ConsoleFrame.class));
	}


}
