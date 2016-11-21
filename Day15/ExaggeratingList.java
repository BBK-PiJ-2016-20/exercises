import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Create a class ExaggeratingList that implements java.util.List for type
 * integer. Implement all methods in the interface, with the following
 * peculiarities:
 *
 * When a small element is added to the list, it is transformed into a bigger
 * element. What small means is decided at construction time (i.e. as a
 * parameter of the constructor of ExaggeratingList).
 *
 * The output of size() is actually twice the number of elements in the list.
 *
 * Pay special attention to the exceptions that must be thrown at each method
 * (according to the interface documentation), especially in the following two
 * cases:
 *
 * No null elements can be added. Bear this in mind and implement the
 * appropriate exceptions to be thrown (according to the interface
 * documentation).
 *
 * The list does not support methods removeAll() and retainAll().
*/
public class ExaggeratingList extends AbstractList<Integer> {
    private List<Integer> list;
    private int smallBoundary;

    /**
     * Create an ExaggeratingList that increases the value of any added element
     * less than smallBoundary.
     */
    public ExaggeratingList(int smallBoundary) {
        this.list = new ArrayList<>();
        this.smallBoundary = smallBoundary;
    }

    public Integer get(int index) {
        return this.list.get(index);
    }

    public int size() {
        return this.list.size() * 2;
    }

}