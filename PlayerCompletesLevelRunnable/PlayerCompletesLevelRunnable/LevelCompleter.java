package PlayerCompletesLevelRunnable;

// Player completes level

public class LevelCompleter implements Runnable {
	private String playerName;
	private int completingTime;
	

	public LevelCompleter(String playerName, int completingTime) {
		super();
		this.playerName = playerName;
		this.completingTime = completingTime;
	}


	@Override
	public void run() {
		System.out.println(playerName + " started completing the level.");
		try {
			Thread.sleep(completingTime * 1000L);
		} catch (InterruptedException e) {
			System.out.println(playerName + " was interrupted while completing the level.");
		}
		System.out.println(playerName + " completed the level.");
		
	}

}