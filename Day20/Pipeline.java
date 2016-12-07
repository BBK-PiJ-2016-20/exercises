import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Turn the strings in the array words into uppercase, keep only the ones that
 * are shorter than 4 characters, and, of what is remaining, keep only the ones
 * that contain "e", and print the first result. Repeat the process, except
 * checking for a "q"" instead of an "e".
 */
 public class Pipeline {
     public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "hello", "bonjour", "tag", "hola", "yes", "no", "si", "oui", "non", "ja", "nein");

        Stream<String> pipeline = makePipeline(words);
        Optional<String> first = pipeline.filter(word -> word.contains("E")).findFirst();
        
        if (first.isPresent()) {
            System.out.println("First changed word containing E: " + first.get());
        } else {
            System.out.println("No changed word contains E");
        }

        pipeline = makePipeline(words);
        first = pipeline.filter(word -> word.contains("Q")).findFirst();

        if (first.isPresent()) {
            System.out.println("First changed word containing Q: " + first.get());
        } else {
            System.out.println("No changed word contains Q");
        }
     }

     public static Stream<String> makePipeline(List<String> source) {
         return source.stream().map(String::toUpperCase).filter(word -> word.length() < 4);
     }

 }