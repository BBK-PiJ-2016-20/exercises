import java.util.Arrays;
import java.util.List;

/**
 * Loop through the words and print each on a separate line, with two spaces in
 * front of each word.
 */
 public class Printer {
     public static void main(String[] args) {
         List<String> words = Arrays.asList("hi", "hello", "bonjour", "tag", "hola");
         words.stream().map(word -> "  " + word).forEach(System.out::println);
     }
 }