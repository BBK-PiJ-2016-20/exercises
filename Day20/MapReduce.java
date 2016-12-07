import java.util.Arrays;
import java.util.List;

/**
 * Produce a single String that is the result of concatenating the uppercase
 * versions of all of the Strings. E.g., the result should be "HIHELLO...". Use
 * a single reduce operation, without using map.
 */
 public class MapReduce {
     public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "hello", "bonjour", "tag", "hola", "yes", "no", "si", "oui", "non", "ja", "nein");
        String changed = words.stream().reduce("", (x, y) -> x + y.toUpperCase());

        System.out.println(changed);
     }
 }