import java.util.Arrays;

/**
 * Create an array containing some Strings. Sort the array by
 *
 * length (i.e., shortest to longest)
 *
 * reverse length (i.e., longest to shortest)
 *
 * first character
 *
 * Strings that contain "e" first, everything else second.
 *
 * Remember that the compare method of Comparator should return a negative
 * number if the first entry is less than the second, a positive number if the
 * first entry is greater than the second, and 0 if they are the same. See the
 * JavaDoc API for details.
 */
 public class StringSorter {
     public static void main(String[] args) {
         String[] strings = new String[] {
             "hello",
             "java",
             "tim",
             "eric",
             "lambda"
         };

         System.out.println("Unsorted: " + Arrays.asList(strings));

         Arrays.sort(strings, (first, second) -> first.length() - second.length());

         System.out.println("Sorted by length: " + Arrays.asList(strings));

         Arrays.sort(strings, (second, first) -> first.length() - second.length());

         System.out.println("Sorted by reverse length: " + Arrays.asList(strings));

         Arrays.sort(strings, (first, second) -> Character.compare(first.charAt(0), second.charAt(0)));

         System.out.println("Sorted by first character: " + Arrays.asList(strings));

         Arrays.sort(strings, (first, second) -> { 
             if (first.contains("e")) {
                 return -1;
             } else if (second.contains("e")) {
                 return 1;
             } else {
                 return 0;
             }
         });

         System.out.println("Sorted by e's first: " + Arrays.asList(strings));


     }

 } 