package org.game.fantasy.quest.game.factory.storyfactory;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.game.story.ConsoleStory;

public class ConsoleStoryFactory extends AbstractStoryFactory<ConsoleStory> {

	private GameContext context;
	
	private static volatile ConsoleStoryFactory consoleStoryFactory;
	
	public static ConsoleStoryFactory getInstance(GameContext context){
		if(consoleStoryFactory == null){
			synchronized(ConsoleStoryFactory.class){
				if(consoleStoryFactory == null){
					consoleStoryFactory = new ConsoleStoryFactory(context);
				}
			}
		}
		return consoleStoryFactory;
	}
	
	private ConsoleStoryFactory(GameContext context){
		this.context = context;
	}
	
	@Override
	public ConsoleStory story() {
		String prince = context.getPlayer().getName();
		
		StringBuilder story = new StringBuilder("This is the story of prince Yagritte !!");
		story.append("\n");
		story.append("\n");
		story.append("Long time ago there was a kingdom of Pandora..");
		story.append("\n");
		story.append("There was a tradition in Pandora that every prince had to go for a quest in order to prove his worth as future king..");
		story.append("\n");
		story.append("Althouh Yagritte had all the qualities to be a great king but traditions were something for which Pandora was known in all the clans..");
		story.append("\n");
		story.append("So finally the day came when Yagritte had to embark on his quest to write his destiny as king..");
		story.append("\n");
		story.append("Elders of Pendora had choosen two of the toughest quest for the prince...but gritt and resolve was something for which Yagritte was known among his people.. ");
		story.append("\n");
		story.append("Gods have bestow their mercy on the prince and send a messiah to help him in his tough times..");
		story.append("\n");
		story.append("The name os massieah was "+prince.toUpperCase());
		story.append("\n");
		story.append("\n");
		story.append("Time will only tell if Yagritte and "+prince+ " will be able to overcome the odds to come out as the future of Pendora...");
		story.append("\n");
		story.append("\n");
		story.append("TO SAVE THE GAME AT ANY STAGE, PRESS 9");
		story.append("\n");
		story.append("Please Choose the Quest....");

		
		return new ConsoleStory(story.toString());
	}

	
}
