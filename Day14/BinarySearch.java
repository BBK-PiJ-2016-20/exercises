import java.util.Collections;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class BinarySearch {
    /**
     * Uses a binary search on a sorted array to find whether or not a value is
     * in a List.
     *
     * @param   needle  the object to search for.
     * @param   haystack the list to search in. Must be sorted.
     */ 
    public static <T extends Comparable<T>> boolean binarySearch(T needle, List<T> haystack) {
        if (haystack.size() == 0) {
            return false;
        }
        int middle = haystack.size() / 2;
        int comparison = needle.compareTo(haystack.get(middle));
        if (comparison < 0) {
            return binarySearch(needle, haystack.subList(0, middle));
        } else if (comparison > 0) {
            return binarySearch(needle, haystack.subList(middle + 1, haystack.size()));
        } else {
            return true;
        }
    }

    /**
     * Generates a sorted array of random integers, then looks for a value in it. The
     * length is given by the first command line argument.
     */ 
    public static void main(String[] args) {
        int elements;
        int needle;
        if (args.length < 2) {
            System.out.println("Specify the number of elements to generate, and the number to search for.");
            return;
        } else {
            elements = Integer.parseInt(args[0]);
            needle = Integer.parseInt(args[1]);
        }
        
        ArrayList<Integer> haystack = new ArrayList<Integer>();
        Random r = new Random();
        for (int i = 0; i < elements; i++) {
            // Generate a random number between 0 and the number of elements in
            // the list. This means it's reasonable likely, but not certain,
            // that the list contains the value.
            haystack.add(r.nextInt(elements));
        }
        Collections.sort(haystack);
        
        System.out.println("Searching for: " + needle);

        System.out.print("In: ");

        for (int i : haystack) {
            System.out.print(i + " ");
        }

        System.out.println("");

        boolean found = binarySearch(needle, haystack);

        if (found) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }
    }
}