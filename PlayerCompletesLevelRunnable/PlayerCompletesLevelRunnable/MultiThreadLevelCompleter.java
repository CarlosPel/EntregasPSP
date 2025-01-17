package PlayerCompletesLevelRunnable;

public class MultiThreadLevelCompleter {
	public static void main(String[] args) {
		LevelCompleter player1 = new LevelCompleter("Paco", 4);
		LevelCompleter player2 = new LevelCompleter("María", 2);
		LevelCompleter player3 = new LevelCompleter("Diego", 1);
		
		Thread thread1 = new Thread(player1);
		Thread thread2 = new Thread(player2);
		Thread thread3 = new Thread(player3);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		System.out.println("All players are completing a level.");
	}
}
