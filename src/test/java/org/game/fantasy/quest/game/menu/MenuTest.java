package org.game.fantasy.quest.game.menu;

import static org.mockito.Mockito.mock;

import java.util.Arrays;

import org.game.fantasy.quest.game.deligate.Deligate;
import org.game.fantasy.quest.game.option.Option;
import org.junit.Test;

public class MenuTest {
	
	@Test
	public void testAddOption() {
		ConsoleMenu menu = new ConsoleMenu();
		Option option = mock(Option.class);
		menu.addOption(option);
	}

	@Test
	public void testSetOptionList() {
		ConsoleMenu menu = new ConsoleMenu();
		Option option1 = mock(Option.class);
		Option option2 = mock(Option.class);
		menu.setOptionList(Arrays.asList(option1, option2));
	}

	@Test
	public void testRegisterDeligate() {
		ConsoleMenu menu = new ConsoleMenu();
		Deligate deligate = mock(Deligate.class);
		menu.registerDeligate(deligate);
	}

}
