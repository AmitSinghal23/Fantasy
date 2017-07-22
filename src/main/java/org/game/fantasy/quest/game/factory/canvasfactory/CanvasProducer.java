package org.game.fantasy.quest.game.factory.canvasfactory;

import org.game.fantasy.quest.display.Canvas;

public class CanvasProducer {

	public static Canvas getCanvas(CanvasType type) {
		switch (type) {
		case CONSOLE:
			return ConsoleCanvasFactory.getInstance().getCanvas();
		default:
			return ConsoleCanvasFactory.getInstance().getCanvas();
		}
	}

	public static enum CanvasType {
		CONSOLE;
	}
}
