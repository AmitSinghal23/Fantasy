package org.game.fantasy.quest.game.factory.questionfactory;

import java.util.List;
import java.util.stream.Collectors;

import org.game.fantasy.quest.game.challenge.CategoryPrompt.Category;
import org.game.fantasy.quest.game.challenge.question.ConsoleQuestion;
import org.game.fantasy.quest.game.challenge.question.Question;

public class QuestionProducer {
	public static List<ConsoleQuestion> getQuestion(QuestionType type) {
		switch (type) {
		case CONSOLE:
			return ConsoleQuestionFactory.getInstance().getQuestionList();
		default:
			return ConsoleQuestionFactory.getInstance().getQuestionList();
		}
	} 

	public static List<? extends Question<String>> getQuestionListByCategoryLevel(Category category){
		List<ConsoleQuestion> consoleQuestionList = getQuestion(QuestionType.CONSOLE);
		return consoleQuestionList.stream().filter(i -> i.getCategory().equals(category) ).collect(Collectors.toList());
	}
		
	public static enum QuestionType {
		CONSOLE;
	}
}
