package PlayerCompletesLevelRunnable;

// Simulates players completing a level in a game using the Runnable interface
public class RunnableLevelCompleter implements Runnable {
	// Name of the player
	private String playerName;
	// Time (in seconds) the player takes to complete the level
	private int completingTime;
	
	// Constructor to initialize player name and completion time
	public RunnableLevelCompleter(String playerName, int completingTime) {
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
        RunnableLevelCompleter player1 = new RunnableLevelCompleter("Paco", 4);
        RunnableLevelCompleter player2 = new RunnableLevelCompleter("María", 2);
        RunnableLevelCompleter player3 = new RunnableLevelCompleter("Diego", 1);
        
        // Create threads for each player
        Thread thread1 = new Thread(player1);
        Thread thread2 = new Thread(player2);
        Thread thread3 = new Thread(player3);
        
        // Start the threads for each player
        thread1.start();
        thread2.start();
        thread3.start();
        
        // Notify that all players are currently completing their levels
        System.out.println("All players are completing a level.");
    }
}

