package org.game.fantasy.quest.game.menu;

import java.util.ArrayList;
import java.util.List;

import org.game.fantasy.quest.game.deligate.Deligate;
import org.game.fantasy.quest.game.option.Option;

public class ConsoleMenu implements Menu<String> {
	
	private List<Option<String>> optionList;
	private List<Deligate> deligateList;
	
	public ConsoleMenu(){
		optionList = new ArrayList<Option<String>>();
		deligateList = new ArrayList<Deligate>();
	}
	
	@Override
	public void addOption(Option<String> option){
		optionList.add(option);
	}

	public List<Option<String>> getOptionList() {
		return optionList;
	}

	@Override
	public void setOptionList(List<Option<String>> optionList) {
		this.optionList = optionList;
	}

	@Override
	public void render() {
		System.out.println("\n");	
		for(Option<String> option: optionList){
			System.out.print(option.getOptionId()+DOT);
			System.out.println(option.getDescription());
		}
	}

	@Override
	public void registerDeligate(Deligate deligate) {
		deligateList.add(deligate);
		
	}

	@Override
	public void processAction() {
		for(Deligate deligate : deligateList){
			new Thread(deligate).start();
		}
		
	}
}
