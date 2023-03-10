import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private final Queue<Runnable> queue = new LinkedList<>();
    private final Object monitor = new Object();

    public void add(Runnable task) {
        synchronized (monitor) {
            queue.add(task);
            monitor.notifyAll();
        }
    }

    public Runnable take() {
        synchronized (monitor) {
            try {
                while (queue.isEmpty()) {
                    monitor.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return queue.poll();
        }
    }
}

