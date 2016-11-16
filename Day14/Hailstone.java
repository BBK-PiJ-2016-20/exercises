import java.util.ArrayList;

public class Hailstone {
    /**
     * Return a sequence of hailstone numbers starting at n.
     */
    public static Iterable<Integer> hailstone(int n) {
        return hailstoneImpl(n, new ArrayList<Integer>());
    }

    private static ArrayList<Integer> hailstoneImpl(int n, ArrayList<Integer> accum) {
        accum.add(n);
        if (n == 1) {
            return accum;
        }
        if (n % 2 == 0) {
            return hailstoneImpl(n / 2, accum);
        } else {
            return hailstoneImpl(3 * n + 1, accum);
        }
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