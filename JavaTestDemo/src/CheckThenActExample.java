public class CheckThenActExample {
    private int counter = 0;

    public void increment() {
        if (counter < 5) {  // Check
            counter++;       // Act
        }
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        CheckThenActExample example = new CheckThenActExample();

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
