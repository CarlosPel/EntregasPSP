package PlayerCompletesLevelRunnable;

import java.util.concurrent.atomic.AtomicInteger;

// Simulates a shared counter with multiple threads updating it
public class RunnableLevelCompleter implements Runnable {
    // Shared counter variable
    private static AtomicInteger sharedCounter = new AtomicInteger(0);

    // The run method contains the logic executed by the thread
    @Override
    public void run() {
        // Increment the shared counter
        int currentCount = sharedCounter.incrementAndGet();
        System.out.println(Thread.currentThread().getName() + " incremented counter to: " + currentCount);
    }

    // Main method to demonstrate the functionality
    public static void main(String[] args) {
        // Create a single instance of RunnableLevelCompleter
        RunnableLevelCompleter completer = new RunnableLevelCompleter();

        // Create multiple threads from the same object
        Thread[] threads = new Thread[99];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(completer, "Thread-" + (i + 1));
        }

        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(thread.getName() + " was interrupted.");
            }
        }

        // Print the final value of the shared counter
        System.out.println("Final counter value: " + sharedCounter.get());
    }
}
