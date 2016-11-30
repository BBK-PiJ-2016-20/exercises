import java.util.concurrent.Executor;
import org.junit.Test;

/**
 * Tests for the implementation of the Executor interface.
 */
public class ExecutorImplTest {
    /**
     * Adding one Runnable should succeed.
     */
    @Test
    public void testAddOne() {
        Executor e = new ExecutorImpl();
        e.execute(new Runnable() { public void run() {} });
    }

    /**
     * Adding a huge number of Runnables should succeed.
     */
    @Test
    public void testAddMany() {
        Executor e = new ExecutorImpl();
        for (int i = 0; i < 1000000; i++) {
            e.execute(new Runnable() { public void run() {} });
        }
    }

    /**
     * Adding null should fail, per the interface definition.
     */
    @Test(expected = NullPointerException.class)
    public void testAddNull() {
        Executor e = new ExecutorImpl();
        e.execute(null);        
    }

    /**
     * Adding a task executes it.
     */
    @Test
    public void testTaskExecute() throws InterruptedException {
        Object result = new Object();        
        Executor e = new ExecutorImpl();

        synchronized(result) {
            e.execute(new Runnable() {
                public void run() {
                    synchronized(result) {
                        result.notifyAll();
                    }
                }
            });

            result.wait();
        }
    }

}