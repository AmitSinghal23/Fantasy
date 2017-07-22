package org.game.fantasy.quest.util;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.game.fantasy.quest.display.Component;
import org.junit.Test;

public class GameComponentsTest {

	@Test
	public void testAdd() {
		GameComponents gameComponents = new GameComponents();
		Component component = mock(Component.class);
		gameComponents.add(component);
		
		assertEquals(1, gameComponents.get().size());
	}

	@Test
	public void testGet() {
		GameComponents gameComponents = new GameComponents();
		Component component = mock(Component.class);
		gameComponents.add(component);
		
		List<Component> expectedList = Arrays.asList(component);
		
		assertEquals(expectedList, gameComponents.get());
	}

}
