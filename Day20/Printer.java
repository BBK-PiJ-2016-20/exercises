import java.util.Arrays;
import java.util.List;

/**
 * Loop through the words and print each on a separate line, with two spaces in
 * front of each word.
 *
 * Repeat the previous problem, but without the two spaces in front. This is
 * trivial if you use the same approach as in (5a), so the point here is to use
 * a method reference.
 */
 public class Printer {
     public static void main(String[] args) {
         List<String> words = Arrays.asList("hi", "hello", "bonjour", "tag", "hola");
         words.stream().forEach(System.out::println);
     }
 }