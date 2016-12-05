import java.util.Random;

/**
 * Create random TimedTask objects, and query the ExecutorImpl about how long
 * the program has left.
 */
public class TimedTaskTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorImpl executor = new ExecutorImpl();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int duration = Math.abs(r.nextInt(2000));
            System.out.println("Adding a task waiting for (ms): " + duration);
            executor.execute(new TimedTask(duration));
            System.out.println("Now the maximum duration is: " + executor.getMaxPendingTime());
        }
        int remaining = executor.getMaxPendingTime();
        System.out.println("All tasks added, now waiting for: " + remaining);
        Thread.sleep(remaining);
        System.exit(0);
    }
}