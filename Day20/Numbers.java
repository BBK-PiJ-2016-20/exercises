import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class Numbers {
    public static void main(String[] args) {
        List<Double> randoms = randomNumberList(10);
        System.out.println("10 random numbers: " + randoms);

        List<Integer> ordered = orderedNumbersList(50, 5, 10);
        System.out.println("10 numbers starting at 50, increasing by 5: " + ordered);
    }

    /**
     * Write a static method that produces a List of a specified length of random
     * numbers. E.g.: List<Double> nums = randomNumberList(someSize);
     *
     */
    public static List<Double> randomNumberList(int count) {
         Random r = new Random();
         return Stream.generate(r::nextDouble)
                        .limit(count)
                        .collect(toList());
     }

     /**
      * Write a static method that produces a list of numbers that go in order
      * by a step size. E.g.: List<Integer> nums = orderedNumberList(50, 5,
      * someSize);
      *
      */
     public static List<Integer> orderedNumbersList(int start, int step, int count) {
         return Stream.iterate(start, x -> x + step)
                        .limit(count)
                        .collect(toList());
     }
 }