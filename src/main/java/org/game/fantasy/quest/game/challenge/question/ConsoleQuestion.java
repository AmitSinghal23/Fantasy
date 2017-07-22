package org.game.fantasy.quest.game.challenge.question;

import java.util.List;

import org.game.fantasy.quest.game.challenge.CategoryPrompt.Category;
import org.game.fantasy.quest.game.option.Option;

public final class ConsoleQuestion implements Question<String>{
	private int questionId;
	private String question;
	private List<Option<String>> options;
	private Level level;
	private Category category;
	private boolean isFinalQuestion;
	
	public ConsoleQuestion(int questionId, String question, List<Option<String>> options, Level level, Category category, boolean isFinalQuestion) {
		this.questionId = questionId;
		this.question = question;
		this.options = options;
		this.level = level;
		this.category = category;
		this.isFinalQuestion = isFinalQuestion;
	}
	
	@Override
	public String getQuestion() {
		return question;
	}
	
	@Override
	public List<Option<String>> getOptions() {
		return options;
	}

	public int getQuestionId() {
		return questionId;
	}

	@Override
	public Level getLevel() {
		return level;
	}

	public Category getCategory() {
		return category;
	}

	@Override
	public void render() {
		char[] tokens = question.toCharArray();
		for(char token: tokens){
			System.out.print(token);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean isFinalQuestion() {
		return isFinalQuestion;
	}
}
