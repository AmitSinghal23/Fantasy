package org.game.fantasy.quest.game.factory.framefactory;

import org.game.fantasy.quest.display.Frame;

public class FrameProducer {

	public static Frame getFrame(FrameType type) {
		switch (type) {
		case CONSOLE:
			return ConsoleFrameFactory.getInstance().getFrame();
		default:
			return ConsoleFrameFactory.getInstance().getFrame();
		}
	}

	public static enum FrameType {
		CONSOLE;
	}
}
