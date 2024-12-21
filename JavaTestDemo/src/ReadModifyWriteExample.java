public class ReadModifyWriteExample {
    private int counter = 0;

    public synchronized void increment() {
        int currentValue = counter;  // Read
        counter = currentValue + 1;  // Modify and Write
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        ReadModifyWriteExample example = new ReadModifyWriteExample();

        // Simulate multiple threads
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                example.increment();
                System.out.println("Thread 1: " + example.getCounter());
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                example.increment();
                System.out.println("Thread 2: " + example.getCounter());
            }
        });

        t1.start();
        t2.start();
    }
}
