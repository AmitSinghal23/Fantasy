package org.game.fantasy.quest.game;

import java.util.List;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.display.Canvas;
import org.game.fantasy.quest.display.Component;
import org.game.fantasy.quest.display.Frame;
import org.game.fantasy.quest.game.challenge.Challenge;
import org.game.fantasy.quest.game.factory.canvasfactory.CanvasProducer;
import org.game.fantasy.quest.game.factory.canvasfactory.CanvasProducer.CanvasType;
import org.game.fantasy.quest.game.factory.framefactory.FrameProducer;
import org.game.fantasy.quest.game.factory.framefactory.FrameProducer.FrameType;
import org.game.fantasy.quest.game.helper.GameEngineHelper;
import org.game.fantasy.quest.game.helper.GameEngineHelperImpl;
import org.game.fantasy.quest.game.menu.Menu;
import org.game.fantasy.quest.game.story.Story;
import org.game.fantasy.quest.util.GameComponents;

public class GameEngine {

	Frame frame;
	Canvas canvas;
	GameEngineHelper<? extends Object> helper;
	
	public GameEngine(GameContext gameContext){
		helper = new GameEngineHelperImpl(gameContext);
	}
	
	public void init(){
		initDisplay();
		addToFrame();
	}
	
	private void renderStory() {
		Story story = helper.getStory();
		clearCanvas();
		addToCanvas(story);
		repaint();
	}

	 
	public void start(){
		captureMenu();
		if(!helper.getGameContext().isProceed()){
			return;
		}
		if(helper.getGameContext().getPlayer() == null){
			captureUser();
			renderStory();
			chooseCategory();
		}
		play();
	}

	private void play() {
		while(helper.getGameContext().isProceed()){
			helper.getGameContext().initializeLatches(1,1);
			playGame();
			
			helper.getGameContext().await();
			
			processResult();
		}
	}

	private void chooseCategory() {
		clearCanvas();
		fillCanvasCategory();
		repaint();
		helper.getGameContext().initializeLatches(1,1);
		deligate();
		helper.getGameContext().await();
		
		processResult();
	}

	private void clearCanvas() {
		canvas.clear();
	}

	private void repaint() {
		frame.show(true);
		frame.repaint();
	}

	private void addToFrame() {
		frame.add(canvas);
	}

	private void addToCanvas(Component component) { 
		canvas.add(component);
	}

	private void initDisplay() {
		frame = FrameProducer.getFrame(FrameType.CONSOLE);
		canvas = CanvasProducer.getCanvas(CanvasType.CONSOLE);
	}
	
	private void fillCanvasCategory(){
		canvas.add(helper.getChallengeCatagory());
	}
	
	private void deligate(){
		GameComponents gameComponents = canvas.getComponents();
		List<Component> componentList = gameComponents.get();
		
		for (Component component : componentList){
			if(component instanceof Menu){
				((Menu) component).processAction();
			}
		}
	}
	
	private void playGame(){
		clearCanvas();
		Challenge<? extends Object> challenge = helper.getChallenge();
		canvas.add(challenge.getChallenge());
		canvas.add(challenge.getMenu());
		repaint();
		deligate();
		
	}
	
	private void processResult(){
		clearCanvas();
		canvas.add(helper.getGameContext().getFooter());
		repaint();
	}
	
	private void captureUser(){
		helper.getGameContext().initializeLatches(1,1);
		getPlayer();
		helper.getGameContext().await();
		processResult();
	}
	
	private void getPlayer(){
		clearCanvas();
		Challenge<? extends Object> challenge = helper.getUserPrompt();
		canvas.add(challenge.getChallenge());
		canvas.add(challenge.getMenu());
		repaint();
		deligate();
	}
	
	private void captureMenu(){
		helper.getGameContext().initializeLatches(1,1);
		getMenuItem();
		helper.getGameContext().await();
		processResult();
	}
	
	private void getMenuItem(){
		clearCanvas();
		Challenge<? extends Object> challenge = helper.getMenuItem();
		canvas.add(challenge.getChallenge());
		canvas.add(challenge.getMenu());
		repaint();
		deligate();
	}
}
