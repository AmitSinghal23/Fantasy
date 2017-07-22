package org.game.fantasy.quest.game.factory.storyfactory;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.context.Player;
import org.game.fantasy.quest.game.story.ConsoleStory;
import org.junit.Test;

public class ConsoleStoryFactoryTest {

	@Test
	public void testStory() {
		GameContext context = new GameContext();
		Player player = new Player("TestPlayer");
		context.setPlayer(player);

		ConsoleStoryFactory factory = ConsoleStoryFactory.getInstance(context);
		assertThat(factory.story(), instanceOf(ConsoleStory.class));
	}

}
