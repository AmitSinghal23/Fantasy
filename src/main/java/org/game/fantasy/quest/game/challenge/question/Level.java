package org.game.fantasy.quest.game.challenge.question;

public enum Level {

	EASY(1, "Easy"),
	MEDIUM(2, "Medium"),
	HARD(3, "Hard");
	
	private int levelId;
	private String levelDescription;
	
	Level(int levelId, String levelDescription){
		this.levelId = levelId;
		this.levelDescription = levelDescription;
	}
	
	public int level(){
		return levelId;
	}
	
	public String description(){
		return levelDescription;
	}
}
