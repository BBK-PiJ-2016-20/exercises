import java.util.List;

/**
 * Provide three ways to use streams to compute the sum of a list of numbers.
 *
 * Rewrite one of the solutions for (10a) so that it can be executed in
 * parallel; verify that you get the same answer as for the sequential code.
 */
public class Sums {
    public static void main(String[] args) {
        List<Integer> integers = Numbers.orderedNumbersList(5, 2, 100);
        int sum1 = integers.parallelStream().mapToInt(i -> i).sum();
        System.out.println("First sum: " + sum1);

        int sum2 = integers.parallelStream().reduce(0, (x, y) -> x + y);
        System.out.println("Second sum: " + sum2);
        
        // Summer contains no synchronization code, so I don't think it's safe
        // to call it from a parallel stream.
        Summer summer = integers.parallelStream().collect(() -> new Summer(0), Summer::addInt, Summer::addSummer);
        int sum3 = summer.getTotal();
        System.out.println("Second sum: " + sum3);
    }
}

/**
 * A class that keeps a total of numbers added to it.
 */
class Summer {
    private int total;

    /**
     * Create a summer, with its total initialised to the given starting
     * value.
     */
    public Summer(int starting) {
        total = starting;
    }

    /**
     * Add the specified int to the total.
     */
    public void addInt(int value) {
        total += value;
    }

    /**
     * Add the total of the specified summer to the total of this summer.
    */
    public void addSummer(Summer other) {
        total += other.getTotal();
    }

    /**
     * Retrieve the summmer's current running total.
     */
    public int getTotal() {
        return total;
    }
}
