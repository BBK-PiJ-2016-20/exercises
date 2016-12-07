import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given two lists of numbers, how would you return all pairs of numbers? For
 * example, given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3),
 * (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)].
 */

 public class Pairer {
     public static void main(String[] args) {
         List<Integer> list1 = Arrays.asList(1, 2, 3);
         List<Integer> list2 = Arrays.asList(3, 4);

         List<Pair> pairs = allPairs(list1, list2);
         System.out.println(pairs);
     }

     public static List<Pair> allPairs(List<Integer> list1, List<Integer> list2) {
         return list1.stream().flatMap((x) -> list2.stream().map((y) -> new Pair(x, y))).collect(Collectors.toList());
     }
 }

 class Pair {
     private int x;
     private int y;

     public Pair(int x, int y) {
         this.x = x;
         this.y = y;
     }

     public int getX() {
         return x;
     }

     public int getY() {
         return y;
     }

     @Override
     public String toString() {
         return "(" + x + ", " + y + ")";
     }
 }