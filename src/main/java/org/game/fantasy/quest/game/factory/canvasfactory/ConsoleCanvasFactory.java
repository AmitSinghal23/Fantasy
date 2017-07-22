package org.game.fantasy.quest.game.factory.canvasfactory;

import org.game.fantasy.quest.display.ConsoleCanvas;

public class ConsoleCanvasFactory extends AbstractCanvasFactory<ConsoleCanvas>{
	
	private static volatile ConsoleCanvasFactory consoleCanvasFactory;
	
	public static ConsoleCanvasFactory getInstance(){
		if(consoleCanvasFactory == null){
			synchronized(ConsoleCanvasFactory.class){
				if(consoleCanvasFactory == null){
					consoleCanvasFactory = new ConsoleCanvasFactory();
				}
			}
		}
		return consoleCanvasFactory;
	}
	
	private ConsoleCanvasFactory(){
	}
	
	@Override
	public ConsoleCanvas getCanvas() {
		return new ConsoleCanvas();
	}

}
