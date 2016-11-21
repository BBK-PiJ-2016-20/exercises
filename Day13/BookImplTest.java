import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test the implementation of the Book interface.
 */
public class BookImplTest {
    /**
     * getAuthor returns the author set in the constructor.
     */
    @Test
    public void testGetAuthor() {
        String expected = "Karl Marx";
        Book book = new BookImpl(expected, "");
        assertEquals(expected, book.getAuthor());
    }

    /**
     * getTitle() returns the title set in the constructor.
     */
    @Test
    public void testGetTitle() {
        String expected = "The Eighteenth Brumaire of Louis Napoleon";
        Book book = new BookImpl("", expected);
        assertEquals(expected, book.getTitle());
    }
}