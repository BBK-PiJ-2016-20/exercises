import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;

/**
 * Create your own implementation of Executor. Look at the documentation of
 * the API of Executor for ideas. Your implementation must be able to execute
 * one Runnable at a time (but you can make it run several tasks in paralel,
 * see also Exercise 6) and must have a queue of pending tasks.
 *
 * Now extend your implementation of Executor so that it has a public method
 * getMaxPendingTime() that returns the maximum theoretical time needed to run
 * all tasks in the queue (i.e assuming all of them last 1000ms).
 */
public class ExecutorImpl implements Executor {

    private BlockingQueue<Runnable> queue;

    private class Worker implements Runnable {
        public void run() {
            while (true) {
                try {
                    Runnable task = queue.take();
                    task.run();
                } catch (InterruptedException ex) {
                    // No action needed, continue waiting.
                }
            }
        }
    }

    public ExecutorImpl() {
        queue = new LinkedBlockingQueue<>();
        (new Thread(new Worker())).start();
    }

    public void execute(Runnable r) {
        if (r == null) {
            throw new NullPointerException();
        } 
        
        try {
            queue.put(r);
        } catch (InterruptedException ex) {
            // Report this failure
            throw new RejectedExecutionException(ex);
        }
    }

    /**
     * The maximum pending time, if each pending task is capped at 1000
     * milliseconds.
     */
    public int getMaxPendingTime() {
        synchronized(queue) {
            // This is size + 1, because the current task may have up to 1000
            // ms to run, before we start running the tasks in the queue.
            return (queue.size() + 1) * 1000;
        }
    }
}