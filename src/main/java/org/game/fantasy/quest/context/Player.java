package org.game.fantasy.quest.context;

import java.io.Serializable;

public final class Player implements Serializable{

	private static final long serialVersionUID = 324093993276724942L;

	private String name;

	public Player(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
