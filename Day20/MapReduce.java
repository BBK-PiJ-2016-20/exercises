import java.util.Arrays;
import java.util.List;

/**
 * Produce a single String that is the result of concatenating the uppercase
 * versions of all of the Strings. E.g., the result should be "HIHELLO...". Use
 * a single reduce operation, without using map.
 *
 * Produce the same String as above, but this time via a map operation that
 * turns the words into upper case, followed by a reduce operation that
 * concatenates them.
 *
 * Produce a String that is all the words concatenated together, but with commas
 * in between. E.g., the result should be "hi,hello,...". Note that there is no
 * comma at the beginning, before "hi", and also no comma at the end, after the
 * last word.
 */
 public class MapReduce {
     public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "hello", "bonjour", "tag", "hola", "yes", "no", "si", "oui", "non", "ja", "nein");
        // 8a 
        // String changed = words.stream().reduce("", (x, y) -> x + y.toUpperCase());
        // 8b 
        // String changed = words.stream().map(String::toUpperCase).reduce("", (x, y) -> x + y);
        String changed = words.stream().reduce((x, y) -> x + "," + y).orElse("");

        System.out.println(changed);
     }
 }