import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Given a list of numbers, how would you return a list of the square of each
 * number? For example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16,
 * 25].
 */
 public class Squarer {
     public static void main(String[] args) {
         List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);

         System.out.println(ints + " squared -> " + squareAll(ints));
     }

     public static List<Integer> squareAll(List<Integer> ints) {
         return ints.stream()
                    .map(x -> x * x)
                    .collect(Collectors.toList());
     }
 }