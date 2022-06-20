package app.Kap13;

public class ThreadTest {
    public int counter = 0;
    public void run() {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++){
                    counter++;
                }
            }, "Thread " + i);
            threads[i].start();
        }
        for (Thread t : threads) {
            while (t.isAlive()) {
                try {
                    t.join();
                } catch (InterruptedException ex) {
                }
            }
        }
        System.out.println(counter);
    }
}