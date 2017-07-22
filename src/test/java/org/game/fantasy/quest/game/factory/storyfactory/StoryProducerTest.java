package org.game.fantasy.quest.game.factory.storyfactory;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.context.Player;
import org.game.fantasy.quest.game.factory.storyfactory.StoryProducer.StoryType;
import org.game.fantasy.quest.game.story.ConsoleStory;
import org.junit.Test;

public class StoryProducerTest {

	@Test
	public void testGetStory() {
		GameContext context = new GameContext();
		Player player = new Player("TestPlayer");
		context.setPlayer(player);

		assertThat(StoryProducer.getStory(StoryType.CONSOLE, context), instanceOf(ConsoleStory.class));
	}

}
