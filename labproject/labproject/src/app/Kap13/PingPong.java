package app.Kap13;

public class PingPong implements Runnable {
        private final String text;
        private final Object monitor;

        public PingPong(String text, Object monitor) {
            this.text = text;
            this.monitor = monitor;
        }

        public void run() {
            synchronized (monitor) {
                while (true) {
                    System.out.println(text);
                    monitor.notify();
                    try {
                        monitor.wait();
                    } catch (InterruptedException ex) {
                    }
                }
            }
        }

    public static void main(String[] args) {
        Object monitor = new Object();
        new Thread(new PingPong("Ping", monitor)).start();
        new Thread(new PingPong("Pong", monitor)).start();
    }
}
