package org.game.fantasy.quest.util;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

public class ConsoleReaderTest {

	Predicate<String> valid;
	Predicate<String> invalid;
	Runnable runnable;
	
	@Before
	public void initialize(){
		valid = text -> text.equals("1") || text.equals("2")|| text.equals("9");
		invalid = text -> text.equals("5") || text.equals("6");
		runnable = mock(Runnable.class);
	}
	
	
	@Test
	public void testReadIntegerUntil() {
		ConsoleReader consoleReader = new ConsoleReader();
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
		System.setIn(in);

		int actual = consoleReader.readIntegerUntil(valid, runnable);
		System.setIn(System.in);
		assertEquals(1, actual);
	}

	@Test(expected = NoSuchElementException.class)
	public void testReadIntegerUntil_Fail() {
		ConsoleReader consoleReader = new ConsoleReader();
		ByteArrayInputStream in = new ByteArrayInputStream("5".getBytes());
		System.setIn(in);

		int actual = consoleReader.readIntegerUntil(valid, runnable);
		System.setIn(System.in);
		assertEquals(1, actual);
	}

	
	@Test
	public void testReadString() {
		ConsoleReader consoleReader = new ConsoleReader();
		ByteArrayInputStream in = new ByteArrayInputStream("TEST".getBytes());
		System.setIn(in);

		String actual = consoleReader.readString();
		System.setIn(System.in);
		assertEquals("TEST", actual);
	}

}
