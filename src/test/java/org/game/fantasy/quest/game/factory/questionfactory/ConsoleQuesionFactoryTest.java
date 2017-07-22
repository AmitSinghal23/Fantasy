package org.game.fantasy.quest.game.factory.questionfactory;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class ConsoleQuesionFactoryTest {

	@Test
	public void testGetQuestionList() {
		ConsoleQuestionFactory factory = ConsoleQuestionFactory.getInstance();
		assertThat(factory.getQuestionList(), instanceOf(List.class));

	}
	
	@Test
	public void testQuestionListSize(){
		ConsoleQuestionFactory factory = ConsoleQuestionFactory.getInstance();
		assertEquals(23, factory.getQuestionList().size());
	}

}
