import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

public class MergesortTest {
    /**
     * Sorting an empty list is an empty list.
     */
    @Test
    public void testEmpty() {
        assertEquals(new ArrayList<Integer>(), Mergesort.sort(new ArrayList<Integer>()));
    }

    /**
     * Sorting a one-element list is that same list.
     */
    @Test
    public void testOne() {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        assertEquals(l, Mergesort.sort(l));
    }

    /**
     * Sorting two elements that are already in order keeps them in order.
     */
    @Test
    public void testTwoOrdered() {
        Integer[] l = new Integer[] {1, 2};
        assertEquals(Arrays.asList(l), Mergesort.sort(Arrays.asList(l)));
    }

    /**
     * Sorting two elements that are out of order swaps them.
     */
    @Test
    public void testTwoUnordered() {
        Integer[] input = new Integer[] {2, 1};
        Integer[] expected = new Integer[] {1, 2};
        assertEquals(Arrays.asList(expected), Mergesort.sort(Arrays.asList(input)));
    }

    /**
     * Sorting a random collection of elements returns the same result as using the built-in java sort.
     */
    @Test
    public void testMany() {
        List<Integer> input = new ArrayList<Integer>();
        Random r = new Random(1);
        int size = Math.abs(r.nextInt(1000));

        for (int i = 0; i < size; i++) {
            input.add(r.nextInt());
        }

        List<Integer> expected = new ArrayList<Integer>(input);
        Collections.sort(expected);

        assertEquals(expected, Mergesort.sort(input));
    }
}