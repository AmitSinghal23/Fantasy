package org.game.fantasy.quest.game.option;

public class ConsoleOption implements Option<String> {
	private int optionId;
	private String description;
	private boolean selected;
	
	public ConsoleOption(int optionId, String description, boolean selected) {
		this.optionId = optionId;
		this.description = description;
		this.selected = selected;
	}

	@Override
	public int getOptionId() {
		return optionId;
	}
	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
