/**
 * Create a class TimedTask that implements Runnable where the run() method is
 * only a call to Thread.sleep() for a number of milliseconds set at creation
 * time. This number must be at most 1000 (if a higher number is given at
 * construction time, it must be capped at 1000).
 */

public class TimedTask implements Runnable {

    private int duration;

    public TimedTask(int duration) {
        if (duration > 1000) {
            duration = 1000;
        }
        this.duration = duration;
    }

    public void run() {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ex) {
            // Let someone else deal with this
            throw new RuntimeException(ex);
        }
        System.out.println("Task finised");
    }
}