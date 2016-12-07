import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
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
 *
 * For the following lists produce the same transformations using filter (you
 * wrote solutions for last exercise sheet):
 *
 * List<String> shortWords = allMatches(words, s -> s.length() < 4);
 *
 * List<String> wordsWithB = allMatches(words, s -> s.contains("b"));
 *
 * List<String> evenLengthWords = allMatches(words, s -> (s.length() % 2) == 0);
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

        List<String> shortWords = allMatches(words, s -> s.length() < 4);
        System.out.println("Short words: " + shortWords);

        List<String> wordsWithB = allMatches(words, s -> s.contains("b"));
        System.out.println("Words with b: " + wordsWithB);

        List<String> evenLengthWords = allMatches(words, s -> (s.length() % 2) == 0);
        System.out.println("Even length words: " + evenLengthWords);
    }

    public static <T> List<T> transformedList(List<T> source, Function<? super T, ? extends T> f) {
        return source.stream().map(f).collect(toList());
    }

    public static <T> List<T> allMatches(List<T> source, Predicate<T> pred) {
        return source.stream().filter(pred).collect(toList());
    }
}