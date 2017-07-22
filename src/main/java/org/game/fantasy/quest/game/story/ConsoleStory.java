package org.game.fantasy.quest.game.story;

public final class ConsoleStory implements Story<String>{
	private String story;
	
	public ConsoleStory(String story) {
		this.story = story;
	}

	@Override
	public String getStory() {
		return story;
	}

	@Override
	public void render() {
		char[] tokens = story.toCharArray();
		for(char token: tokens){
			System.out.print(token);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}



}
