import java.util.Deque;
import java.util.LinkedList;

public class Hailstone {
    /**
     * Return a sequence of hailstone numbers starting at n.
     */
    public static Iterable<Integer> hailstone(int n) {
        return hailstoneImpl(n);
    }

    private static Deque<Integer> hailstoneImpl(int n) {
        Deque<Integer> result;

        if (n == 1) {
            result = new LinkedList<Integer>();
            result.push(1);
            return result;
        }
        if (n % 2 == 0) {
            result = hailstoneImpl(n / 2);
        } else {
            result = hailstoneImpl(3 * n + 1);
        }
        result.push(n);
        return result;
    }

    public static void main(String[] args) {
        int n;
        if (args.length < 1) {
            n = 10;
        } else {
            n = Integer.parseInt(args[0]);
        }
        for (int i : hailstone(n)) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}