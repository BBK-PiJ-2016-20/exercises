import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;

/**
 * Create a list of Integer that keeps itself sorted by sorting itself when
 * others are not looking. The list must have at least methods add(Integer)
 * (to add new Integers) and get(int) (to get the ith integer in the (sorted)
 * list).
 */
public class SelfSortingList implements Runnable {
    private List<Integer> storage;
    private Deque<Integer> unsorted;
    private boolean isSorted;
    private int getting;
    private boolean finished;

    public SelfSortingList() {
        storage = new ArrayList<>();
        unsorted = new ArrayDeque<>();
        isSorted = true;
        getting = 0;
        finished = false;

        (new Thread(this)).start();
    }

    /**
     * Notify the list that it is not longer in use and the sorting thread can
     * shut down.
     */
    public synchronized void finish() {
        finished = true;
        notifyAll();
    }

    /**
     * The add() method must add the new element at the end of the list, mark
     * the list as not sorted and return immediately.
     */
    public synchronized void add(Integer i) {
        waitForNoGetting();
        isSorted = false;        
        unsorted.addFirst(i);
        notifyAll();
    }

    private void waitForNoGetting() {
        while (getting > 0 && !finished) {
            try {
                wait();
            } catch (InterruptedException ex) {
                // No action needed, but show the stack trace for debugging.
                ex.printStackTrace(); 
            }
        }
    }

    /**
     * The method get(int) must always return the ith integer in the (sorted)
     * list; if this method is called while the list is not sorted, the list
     * must be fully sorted before it can return; no additional elements can
     * be added until the call of get(int) returns.
     */
    public synchronized int get(int index) {
        getting++;
        waitTillSorted(true);
        getting--;
        if (getting == 0) {
            notifyAll();
        }        
        return storage.get(index);
    }

    /**
     * Return the size of the list.
     */
    public synchronized int size() {
        return storage.size() + unsorted.size();
    }

    /**
     * Another thread must be always observing the list and checking whether
     * it is sorted; if it is, it must mark it as sorted; if it is not, the
     * thread must sort it. The thread must re-order the list in small steps
     * to make sure it does not cause additional delay when new elements are
     * added to the list while it is sorting itself (i.e. do not include a
     * long loop in your synchronised code that may block the addition of new
     * elements for a long time).
     */
    public void run() {
        while (!finished) {
            waitTillSorted(false);
            insertOne();
        }
    }


    /**
     * Wait until the state of isSorted matches the supplied state. i.e.,
     * waitTillSorted(true) waits until the list is sorted.
     */
    private synchronized void waitTillSorted(boolean state) {
        while (isSorted != state && !finished) {
            try {
                wait();
            } catch (InterruptedException ex) {
                // Don't need to take any action here, just repeat the loop,
                // but print stack track for debugging. 
                ex.printStackTrace();
            }
        }
    }

    /**
     * Insert one item from the collection of unsorted elements into the right
     * place in the sorted list. If there are no unsorted elements, sets
     * isSorted to true and notifies any waiting threads.
     */
    private synchronized void insertOne() {
        Integer value = unsorted.pollLast();
        if (value == null) {
            isSorted = true;
            notifyAll();
            return;
        }

        // Could speed things up by using a binary search to find the
        // insertion point here.
        boolean added = false;
        for (int i = 0; i < storage.size(); i++) {
            int toCheck = storage.get(i);
            if (toCheck > value) {
                storage.add(i, value);
                added = true;
                break;
            }
        }
        if (!added) {
            storage.add(value);
        }
    }
}