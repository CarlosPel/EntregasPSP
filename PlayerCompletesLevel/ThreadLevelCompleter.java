package PlayerCompletesLevel;

// Simulates players completing a level in a game using threads
public class ThreadLevelCompleter extends Thread {
	// Name of the player
	private String playerName;
	// Time (in seconds) the player takes to complete the level
	private int completingTime;
	
	// Constructor to initialize player name and completion time
	public ThreadLevelCompleter(String playerName, int completingTime) {
		super();
		this.playerName = playerName;
		this.completingTime = completingTime;     
	}
	
	// The run method contains the logic executed by the thread
	@Override
	public void run() {
		// Indicate that the player has started completing the level
		System.out.println(playerName + " started completing the level.");
		try {
			// Simulate the time taken to complete the level using Thread.sleep
			Thread.sleep(completingTime * 1000L);
		} catch (InterruptedException e) {
			// Handle interruptions gracefully
			System.out.println(playerName + " was interrupted while completing the level.");
		}
		// Indicate that the player has finished completing the level
		System.out.println(playerName + " completed the level.");

	}

	// Main method to demonstrate the functionality of LevelCompleter
	public static void main(String[] args) {
		// Create instances of LevelCompleter for each player
		ThreadLevelCompleter player1 = new ThreadLevelCompleter("Paco", 4);
		ThreadLevelCompleter player2 = new ThreadLevelCompleter("María", 2);
		ThreadLevelCompleter player3 = new ThreadLevelCompleter("Diego", 1);

		// Start the threads for each player
		player1.start();
		player2.start();
		player3.start();

		// Notify that all players are currently completing their levels
		System.out.println("All players are completing a level.");
	}
}
