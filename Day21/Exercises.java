//package java8.lambdahol;

/*
 * For each exercise, develop a solution using Java SE 8 Lambda/Streams
 * and remove the @Ignore tag.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Exercises {

    @Before
    public void setUpBufferedReader() throws IOException {
        reader = Files.newBufferedReader(
                Paths.get("SonnetI.txt"), StandardCharsets.UTF_8);
    }

    @After
    public void closeBufferedReader() throws IOException {
        reader.close();
    }


    static final String REGEXP = "\\W+"; // for splitting into words

    static List<String> wordList = Arrays.asList(
            "every", "problem", "in", "computer", "science",
            "can", "be", "solved", "by", "adding", "another",
            "level", "of", "indirection");

    private BufferedReader reader;

    // Exercise 1: Print out all the words in wordList, which is a static List<String> .

    @Test
    public void printAllWords() {
        /* TODO */

        // We will give you this one to show you the "style"
        // wordList.forEach(System.out::println);

        // no assertions
    }

    // Exercise 2: Convert all words in wordList to upper case,
    // and gather the result into an output list.

    @Test
    public void upperCaseWords() {
        List<String> output = wordList.stream().map(String::toUpperCase).collect(toList());

        assertEquals(
                Arrays.asList(
                        "EVERY", "PROBLEM", "IN", "COMPUTER", "SCIENCE",
                        "CAN", "BE", "SOLVED", "BY", "ADDING", "ANOTHER",
                        "LEVEL", "OF", "INDIRECTION"),
                output);
    }


    // Exercise 3: Find all the words in wordList that have even length
    // and put them into an output list.

    @Test
    public void findEvenLengthWords() {
        List<String> output = wordList.stream().filter(string -> string.length() %2 == 0).collect(toList());

        assertEquals(
                Arrays.asList(
                        "in", "computer", "be", "solved", "by", "adding", "of"),
                output);
    }

   // Exercise 4: Count the number of lines in a file. The field *reader*
    // is a BufferedReader which will be opened for you on the text file.
    // See the JUnit @Before and @After methods at the bottom of this file.
    // The text file is "SonnetI.txt" (Shakespeare's first sonnet) which is
    // located at the root of this NetBeans project.

    @Test
    public void countLinesInFile() throws IOException {
        long count = reader.lines().count();

        assertEquals(14, count);
    }


    // Exercise 5: Join lines 3-4 from the text file into a single string.

    @Test
    public void joinLineRange() throws IOException {
        String output = reader.lines().skip(2).limit(2).reduce("", String::concat);

        assertEquals(
                "But as the riper should by time decease," +
                        "His tender heir might bear his memory:",
                output);
    }

    // Exercise 6: Find the length of the longest line in the file.

    @Test
    public void lengthOfLongestLine() throws IOException {
        OptionalInt maxLength = reader.lines().mapToInt(String::length).max(); 
        int longest = maxLength.getAsInt();

        assertEquals(longest, 53);
    }

   // Exercise 7: Collect all the words from the text file into a list.
    // Hint: use String.split(REGEXP) to split a string into words.
    // Splitting this way results in "words" that are the empty string,
    // which should be discarded. REGEXP is defined at the bottom of this file.


    @Test
    public void listOfAllWords() throws IOException {
        List<String> output = reader.lines().map(line -> line.split(REGEXP))
                                            .flatMap(Arrays::stream)
                                            .filter(word -> !word.isEmpty())
                                            .collect(toList());

        assertEquals(
                Arrays.asList(
                        "From", "fairest", "creatures", "we", "desire", "increase",
                        "That", "thereby", "beauty", "s", "rose", "might", "never", "die",
                        "But", "as", "the", "riper", "should", "by", "time", "decease",
                        "His", "tender", "heir", "might", "bear", "his", "memory", "But",
                        "thou", "contracted", "to", "thine", "own", "bright", "eyes",
                        "Feed", "st", "thy", "light", "s", "flame", "with", "self",
                        "substantial", "fuel", "Making", "a", "famine", "where",
                        "abundance", "lies", "Thy", "self", "thy", "foe", "to", "thy",
                        "sweet", "self", "too", "cruel", "Thou", "that", "art", "now",
                        "the", "world", "s", "fresh", "ornament", "And", "only", "herald",
                        "to", "the", "gaudy", "spring", "Within", "thine", "own", "bud",
                        "buriest", "thy", "content", "And", "tender", "churl", "mak",
                        "st", "waste", "in", "niggarding", "Pity", "the", "world", "or",
                        "else", "this", "glutton", "be", "To", "eat", "the", "world", "s",
                        "due", "by", "the", "grave", "and", "thee"),
                output);
    }

    // Exercise 8: Create a list containing the words, lowercased, in alphabetical order.

    @Test
    public void sortedLowerCase() throws IOException {
        List<String> output = reader.lines().map(line -> line.split(REGEXP))
                                            .flatMap(Arrays::stream)
                                            .filter(word -> !word.isEmpty())
                                            .map(String::toLowerCase)
                                            .sorted()
                                            .collect(toList());

        assertEquals(
                Arrays.asList(
                        "a", "abundance", "and", "and", "and", "art", "as", "be",
                        "bear", "beauty", "bright", "bud", "buriest", "but", "but",
                        "by", "by", "churl", "content", "contracted", "creatures",
                        "cruel", "decease", "desire", "die", "due", "eat", "else",
                        "eyes", "fairest", "famine", "feed", "flame", "foe", "fresh",
                        "from", "fuel", "gaudy", "glutton", "grave", "heir", "herald",
                        "his", "his", "in", "increase", "lies", "light", "mak",
                        "making", "memory", "might", "might", "never", "niggarding",
                        "now", "only", "or", "ornament", "own", "own", "pity",
                        "riper", "rose", "s", "s", "s", "s", "self", "self", "self",
                        "should", "spring", "st", "st", "substantial", "sweet",
                        "tender", "tender", "that", "that", "the", "the", "the",
                        "the", "the", "the", "thee", "thereby", "thine", "thine",
                        "this", "thou", "thou", "thy", "thy", "thy", "thy", "thy",
                        "time", "to", "to", "to", "to", "too", "waste", "we", "where",
                        "with", "within", "world", "world", "world"),
                output);
    }


    // Exercise 9: Sort unique, lower-cased words by length, then alphabetically
    // within length, and place the result into an output list.


    @Test
    public void sortedLowerCaseDistinctByLengthThenAlphabetically() throws IOException {
        Stream<String> distinctWords = reader.lines().map(line -> line.split(REGEXP))
                                            .flatMap(Arrays::stream)
                                            .filter(word -> !word.isEmpty())
                                            .map(String::toLowerCase)
                                            .distinct();
        List<String> output = distinctWords.sorted((word1, word2) -> {
                                                if (word1.length() != word2.length()) {
                                                    return word1.length() - word2.length();
                                                } else {
                                                    return word1.compareTo(word2);
                                                }
                                            })
                                            .collect(toList());
        assertEquals(
                Arrays.asList(
                        "a", "s", "as", "be", "by", "in", "or", "st", "to", "we",
                        "and", "art", "bud", "but", "die", "due", "eat", "foe", "his",
                        "mak", "now", "own", "the", "thy", "too", "bear", "else",
                        "eyes", "feed", "from", "fuel", "heir", "lies", "only",
                        "pity", "rose", "self", "that", "thee", "this", "thou",
                        "time", "with", "churl", "cruel", "flame", "fresh", "gaudy",
                        "grave", "light", "might", "never", "riper", "sweet", "thine",
                        "waste", "where", "world", "beauty", "bright", "desire",
                        "famine", "herald", "making", "memory", "should", "spring",
                        "tender", "within", "buriest", "content", "decease",
                        "fairest", "glutton", "thereby", "increase", "ornament",
                        "abundance", "creatures", "contracted", "niggarding",
                        "substantial"),
                output);
    }

    // Exercise 10: Categorize the words into a map, where the map's key is
    // the length of each word, and the value corresponding to a key is a
    // list of words of that length. Don't bother with uniqueness or lower-
    // casing the words.


    @Test
    public void mapLengthToWordList() throws IOException {
        Map<Integer, List<String>> map = 
            reader.lines()
                  .map(line -> line.split(REGEXP))
                  .flatMap(Arrays::stream)
                  .collect(groupingBy(String::length));

        assertEquals(6, map.get(7).size());
        assertEquals(Arrays.asList("increase", "ornament"), map.get(8));
        assertEquals(Arrays.asList("creatures", "abundance"), map.get(9));
        assertEquals(Arrays.asList("contracted", "niggarding"), map.get(10));
        assertEquals(Arrays.asList("substantial"), map.get(11));
        assertFalse(map.containsKey(12));
    }

    // Exercise 11: Gather the words into a map, accumulating a count of the
    // number of occurrences of each word. Don't worry about upper case and
    // lower case.

    @Test
    public void wordFrequencies() throws IOException {
        Map<String, Long> map = 
            reader.lines()
                  .map(line -> line.split(REGEXP))
                  .flatMap(Arrays::stream)
                  .collect(groupingBy(string -> string, counting()));

        assertEquals(2L, (long) map.get("tender"));
        assertEquals(6L, (long) map.get("the"));
        assertEquals(1L, (long) map.get("churl"));
        assertEquals(2L, (long) map.get("thine"));
        assertEquals(3L, (long) map.get("world"));
        assertFalse(map.containsKey("java8"));
    }

    // Exercise 12: Create a nested grouping, where the outer map is a map
    // from the first letter of the word to a submap. (Use a string of length
    // one as the key.) The submap, in turn, is a mapping from the length of the
    // word to a list of words with that length. Don't bother with any downcasting
    // or  worrying about the uniqueness of the words.
    //
    // For example, given the words "foo bar baz bazz" the top level map would have
    // a keys of "f" and "b". The value corresponding to "b" would be a map with
    // a key of 3 with a value of [bar baz] (a list of Strings) and a key of 4
    // with a value of [bazz] (a one-element list of String).
    @Ignore
    @Test
    public void nestedGrouping() throws IOException {
        Map<String, Map<Integer, List<String>>> map = null; 

        assertEquals("[From, Feed]", map.get("F").get(4).toString());
        assertEquals("[by, be, by]", map.get("b").get(2).toString());
        assertEquals("[the, thy, thy, thy, too, the, the, thy, the, the, the]",
                map.get("t").get(3).toString());
        assertEquals("[beauty, bright]", map.get("b").get(6).toString());
    }
}
