package PlayerCompletesLevel;

public class MultiThreadLevelCompleter {
	public static void main(String[] args) {
		LevelCompleter player1 = new LevelCompleter("Paco", 3);
		LevelCompleter player2 = new LevelCompleter("María", 2);
		LevelCompleter player3 = new LevelCompleter("Diego", 1);
		
		player1.start();
		player2.start();
		player3.start();
		
		System.out.println("All players are completing a level.");
	}
}
