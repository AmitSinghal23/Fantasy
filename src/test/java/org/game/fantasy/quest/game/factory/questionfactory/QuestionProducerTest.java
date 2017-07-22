package org.game.fantasy.quest.game.factory.questionfactory;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.game.fantasy.quest.game.challenge.CategoryPrompt.Category;
import org.game.fantasy.quest.game.factory.questionfactory.QuestionProducer.QuestionType;
import org.junit.Test;

public class QuestionProducerTest {

	@Test
	public void testGetQuestion() {
		assertThat(QuestionProducer.getQuestion(QuestionType.CONSOLE), instanceOf(List.class));
	}

	@Test
	public void testGetQuestionListByCategoryLevel() {
		assertThat(QuestionProducer.getQuestionListByCategoryLevel(Category.HISTORY), instanceOf(List.class));
	}

	@Test
	public void testGetQuestion_Size() {
		assertEquals(23, QuestionProducer.getQuestion(QuestionType.CONSOLE).size());
	}

	@Test
	public void testGetQuestionListByCategoryLevel_Size() {
		assertEquals(15, QuestionProducer.getQuestionListByCategoryLevel(Category.HISTORY).size());
	}
}
