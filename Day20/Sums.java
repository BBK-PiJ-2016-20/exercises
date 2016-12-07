import java.util.List;

/**
 * Provide three ways to use streams to compute the sum of a list of numbers.
 */
public class Sums {
    public static void main(String[] args) {
        List<Integer> integers = Numbers.orderedNumbersList(5, 2, 10);
        int sum1 = integers.stream().mapToInt(i -> i).sum();
        System.out.println("First sum: " + sum1);

        int sum2 = integers.stream().reduce(0, (x, y) -> x + y);
        System.out.println("Second sum: " + sum2);

        Summer summer = integers.stream().collect(() -> new Summer(0), Summer::addInt, Summer::addSummer);
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
