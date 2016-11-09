import org.junit.*;
import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void testsNormalName() {
        String input = "Dereck Robert Yssirt";
        String output = Person.getInitials(input);
        String expected = "DRY";
        assertEquals(output, expected);
    }

    /**
     * Reproduce the bug in which names with multiple spaces between words
     * are not processed correctly.
     */
    @Test
    public void testMultipleSpaces() {
        assertEquals(Person.getInitials("Multiple   Spaces"), "MS");
    }
}