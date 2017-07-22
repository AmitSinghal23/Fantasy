package org.game.fantasy.quest.context;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;

import org.game.fantasy.quest.game.challenge.CategoryPrompt.Category;
import org.game.fantasy.quest.game.challenge.footer.Footer;
import org.game.fantasy.quest.game.challenge.question.Level;

public class GameContext implements Serializable{

	private static final long serialVersionUID = -6791463020920776209L;
	
	public GameContext(){
	}
	
	private class GameState implements Serializable{
		private static final long serialVersionUID = 8061202058271136380L;

		public Category category;
		public Level level;
		public int index;

		public GameState() {
		}
	}
	
	private Player player;
	private GameState state = new GameState();
	private boolean proceed = true;
	private transient CountDownLatch deligateLatch;
	private transient CountDownLatch resultLatch;
	private Footer footer;
	private boolean levelChange;
	private boolean isFinalState;
	private boolean savedStatus;
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Category getCategory() {
		return state.category;
	}
	public void setCategory(Category category) {
		this.state.category = category;
	}
	public boolean isProceed() {
		return proceed;
	}
	public void setProceed(boolean proceed) {
		this.proceed = proceed;
	}
	public Level getLevel() {
		return state.level;
	}
	public void setLevel(Level level) {
		this.state.level = level;
	}
	public int getIndex() {
		return state.index;
	}
	public void setIndex(int index) {
		this.state.index = index;
	}
	
	public void initializeLatches(int deligateLatchCount, int resultLatchCount){
		deligateLatch = new CountDownLatch(deligateLatchCount);
		resultLatch = new CountDownLatch(resultLatchCount);
	}
	
	public CountDownLatch getDeligateLatch() {
		return deligateLatch;
	}
	
	public CountDownLatch getResultLatch() {
		return resultLatch;
	}
	
	public void await(){
		try {
			deligateLatch.await();
			resultLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public Footer getFooter() {
		return footer;
	}
	public void setFooter(Footer footer) {
		this.footer = footer;
	}

	public boolean isFinalState() {
		return isFinalState;
	}
	public void setFinalState(boolean isFinalState) {
		this.isFinalState = isFinalState;
	}
	public boolean isLevelChange() {
		return levelChange;
	}
	public void setLevelChange(boolean levelChange) {
		this.levelChange = levelChange;
	}
	public boolean isSavedStatus() {
		return savedStatus;
	}
	public void setSavedStatus(boolean savedStatus) {
		this.savedStatus = savedStatus;
	}

}
