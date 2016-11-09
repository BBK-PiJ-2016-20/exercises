import org.junit.*;
import static org.junit.Assert.*;

public class InitialsTest {
    @Test
    public void testsNormalName() {
        String input = "Dereck Robert Yssirt";
        String output = Initials.getInitials(input);
        String expected = "DRY";
        assertEquals(output, expected);
    }

    /**
     * Reproduce the bug in which names with multiple spaces between words
     * are not processed correctly.
     */
    @Test
    public void testMultipleSpaces() {
        assertEquals(Initials.getInitials("Multiple   Spaces"), "MS");
    }
}