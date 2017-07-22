package org.game.fantasy.quest.display;

public interface Component {
	
	public final static String DOT = ". ";

	public void render();
	public default void renderChoice(){
		System.out.println("\n");
		System.out.println("Choose.... but beware !!!! This may be your last choice....");
	}
}
 