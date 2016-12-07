import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

/**
 * Write a static method that produces a List of a specified length of random
 * numbers. E.g.: List<Double> nums = randomNumberList(someSize);
 *
 */
 public class Numbers {
     public static void main(String[] args) {
         List<Double> nums = randomNumberList(10);

         System.out.println("10 random numbers: " + nums);
     }

     public static List<Double> randomNumberList(int count) {
         Random r = new Random();
         return Stream.generate(r::nextDouble).limit(count).collect(toList());
     }
 }