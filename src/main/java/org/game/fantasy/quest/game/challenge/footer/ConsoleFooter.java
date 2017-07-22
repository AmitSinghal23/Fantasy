package org.game.fantasy.quest.game.challenge.footer;

public class ConsoleFooter implements Footer{

	private static final long serialVersionUID = 7935317696066668429L;

	private String description;
	
	public ConsoleFooter(String description) {
		this.description = description;
	}

	@Override
	public void render() {
		char[] tokens = description.toCharArray();
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
