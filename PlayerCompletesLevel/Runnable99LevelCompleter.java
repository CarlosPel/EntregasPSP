package PlayerCompletesLevel;

// Simulates players completing a level in a game using the Runnable interface
public class Runnable99LevelCompleter implements Runnable {
	// Name of the player
	private String playerName;
	// Time (in seconds) the player takes to complete the level
	private int completingTime;
	// Shared counter to track global duration
	private static int globalDuration = 0;
	
	// Constructor to initialize player name and completion time
	public Runnable99LevelCompleter(String playerName) {
		super();
		this.playerName = playerName;
        this.completingTime = globalDuration;
	}

	// The run method contains the logic executed by the thread
	@Override
	public void run() {
		try {
			// Increment the global counter
			globalDuration ++;
			System.out.println(globalDuration);
			// Simulate the time taken to complete the level using Thread.sleep
			Thread.sleep(completingTime * 1000L);
		} catch (InterruptedException e) {
			// Handle interruptions gracefully
			System.out.println(playerName + " was interrupted while completing the level.");
		}
	}
	
    // Main method to demonstrate the functionality of LevelCompleter
    public static void main(String[] args) {
		// Number of threads
		int threadNumber = 999; 
        // Create instances of LevelCompleter for the first player
        Runnable99LevelCompleter player1 = new Runnable99LevelCompleter("Paco");
        
        // Create threads for the first player
        Thread thread1 = new Thread(player1);
        
        // Start the threads for the first player
        thread1.start();
        
		for (int i = 0; i < threadNumber; i++) {
        	// Create instances of LevelCompleter for each player
            Runnable99LevelCompleter player = new Runnable99LevelCompleter("Player_" + i);
			// Create threads for each player
            Thread thread = new Thread(player);
        	// Start the threads for each player
            thread.start();
        }
        
        // Notify that all players are currently completing their levels
        System.out.println("\nAll players are completing a level...\n");
    }
}