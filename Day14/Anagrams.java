import java.util.ArrayList;
import java.util.List;

public class Anagrams {
    /**
     * Return all the anagrams of s (that is, all the permutations of the
     * characters; does not attempt to find real words in the resulting
     * strings). Note that if there are repeated characters in s, there will be
     * repeated anagrams in the result list.
     */
    public static List<String> anagrams(String s) {
        ArrayList<String> results = new ArrayList<String>();

        if (s.length() == 0) {
            results.add("");
            return results;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String rest = s.substring(0, i) + s.substring(i + 1);
            for (String restAnagram : anagrams(rest)) {
                results.add(c + restAnagram);
            }
        }

        return results;
    }
}