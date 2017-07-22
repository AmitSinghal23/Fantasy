package org.game.fantasy.quest.util.marshaller;

public class MarshalStoreValidator {
	public void validate(){
		String path = System.getProperty("quest.file");
		if(path == null){
			throw new IllegalArgumentException("Please specify quest.file property while starting new game !!");
		}

	}
}
