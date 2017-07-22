package org.game.fantasy.quest.launcher;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.game.fantasy.quest.context.GameContext;
import org.game.fantasy.quest.game.GameLauncher;

public class LauncherWorker {

	public void init() {
		launchGame(loadContext());
	}

	private void launchGame(GameContext context) {
		GameLauncher gameLauncher = new GameLauncher(context);
		ExecutorService executor = Executors.newFixedThreadPool(1);

		try {
			Future future = executor.submit(gameLauncher);

			if (future.get() == null) {
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			executor.shutdownNow();
		} catch (ExecutionException e) {
			e.printStackTrace();
			executor.shutdownNow();
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
			executor.shutdownNow();
		}

	}

	private GameContext loadContext() {
		GameContext context = new GameContext();
		return context;
	}
}
