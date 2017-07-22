package org.game.fantasy.quest.game.factory.storyfactory;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.game.story.Story;

public class StoryProducer {
	
	public static Story getStory(StoryType type, GameContext context){
		switch(type) {
		case CONSOLE:
			return ConsoleStoryFactory.getInstance(context).story();
		default:
			return ConsoleStoryFactory.getInstance(context).story(); 
		}
	}
	
public static enum StoryType{
CONSOLE;	
}
}
