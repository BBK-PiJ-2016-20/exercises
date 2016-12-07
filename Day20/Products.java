import java.util.List;

/**
 * Now, use streams to compute the product of some doubles. Show that serial
 * and parallel versions do not always give the same answer. (Note: this is a
 * bit tricky, because it seems at first that multiplication is associative,
 * as required by the parallel reduce. It will be impossible to illustrate the
 * result if you have a single-core computer.)
 */
public class Products {
    public static void main(String[] args) {
        List<Double> doubles = Numbers.randomNumberList(100);
        double result = doubles.parallelStream().reduce(1.0, (x, y) -> x * y);
        System.out.println("Product: " + result);
    }
}
