import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

public class AnagramsTest{
    /**
     * An empty string has one anagram, the empty string.
    */
    @Test
    public void testEmptyString() {
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("");

        assertEquals(expected, Anagrams.anagrams(""));
    }

    /**
     * A single character string has exactly one anagrams.
     */
    @Test
    public void testOneCharacterOneAnagrams() {
        assertEquals(1, Anagrams.anagrams("a").size());
    }

    /**
     * A single character string's anagrams is that single character.
     */
    @Test
    public void testOneCharacter() {
        assertTrue(Anagrams.anagrams("a").contains("a"));
    }

    /**
     * A two-character string has two anagrams.
     */
    @Test
    public void testTwoCharactersTwoAnagrams() {
        assertEquals(2, Anagrams.anagrams("ab").size());
    }
    
    /**
     * A two character string's anagrams are ab and b.
     */
    @Test
    public void testTwoCharacters() {
        List<String> result = Anagrams.anagrams("ab");
        assertTrue("Contains ab", result.contains("ab"));
        assertTrue("Contains ba", result.contains("ba"));
    }

    /**
     * A three character string has six anagrams.
     */
    @Test
    public void testThreeCharactersSixAnagrams() {
        assertEquals(6, Anagrams.anagrams("abc").size());
    }

    /**
     * A three character string's anagrams are abc, acb, bac, bca, cba, cab.
     */
    @Test
    public void testThreeCharacters() {
        String[] allExpected = new String[]{
            "abc",
            "acb",
            "bac",
            "bca",
            "cba",
            "cab"
        };

        List<String> result = Anagrams.anagrams("abc");
        for (String expected : allExpected) {
            assertTrue("Contains " + expected, result.contains(expected));
        }
    } 
}