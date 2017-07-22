package org.game.fantasy.quest.game.factory.framefactory;

import org.game.fantasy.quest.display.ConsoleFrame;

public class ConsoleFrameFactory extends AbstractFrameFactory<ConsoleFrame>{

	private static volatile ConsoleFrameFactory consoleFrameFactory;
	
	public static ConsoleFrameFactory getInstance(){
		if(consoleFrameFactory == null){
			synchronized(ConsoleFrameFactory.class){
				if(consoleFrameFactory == null){
					consoleFrameFactory = new ConsoleFrameFactory();
				}
			}
		}
		return consoleFrameFactory;
	}
	
	private ConsoleFrameFactory() {
		super();
	}

	@Override
	public ConsoleFrame getFrame() {
		return new ConsoleFrame();
	}
	
	
	public String toString(){
		return "This is Console Frame";
	}

}
