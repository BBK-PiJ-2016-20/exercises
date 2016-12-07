import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import static java.util.stream.Collectors.toList;

/**
 * For the following expressions, which you wrote for the last exercise sheet,
 * produce the same transformations using map:
 *
 * List<String> excitingWords = transformedList(words, s -> s + "!");
 *
 * List<String> eyeWords = transformedList(words, s -> s.replace("i", "eye")); 
 * 
 * List<String> upperCaseWords = transformedList(words, String::toUpperCase);
 */
public class Transformations {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "hello", "bonjour", "tag", "hola");

        List<String> excitingWords = transformedList(words, s -> s + "!");
        System.out.println("Exciting words: " + excitingWords);

        List<String> eyeWords = transformedList(words, s -> s.replace("i", "eye"));
        System.out.println("Eye words: " + eyeWords);

        List<String> upperCaseWords = transformedList(words, String::toUpperCase);        
        System.out.println("Upper case words: " + upperCaseWords);
    }

    public static <T> List<T> transformedList(List<T> source, Function<? super T, ? extends T> f) {
        return source.stream().map(f).collect(toList());
    }
}