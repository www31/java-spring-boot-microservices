import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    // Semaphore with 1 permit (acting like a mutex)
    private static final Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        // Create two threads
        Thread thread1 = new Thread(new Task(), "Thread 1");
        Thread thread2 = new Thread(new Task(), "Thread 2");

        // Start the threads
        thread1.start();
        thread2.start();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                // Acquire the semaphore (decreases the number of available permits)
                System.out.println(Thread.currentThread().getName() + " is attempting to acquire the semaphore.");
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " has acquired the semaphore.");

                // Simulate some work by the thread
                Thread.sleep(2000); // Simulate some processing time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // Release the semaphore (increases the number of available permits)
                System.out.println(Thread.currentThread().getName() + " is releasing the semaphore.");
                semaphore.release();
            }
        }
    }

}
