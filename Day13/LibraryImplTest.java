import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test the Library implementation.
 */
public class LibraryImplTest {
    /**
     * getName() returns the name set in the constructor.
     */
    @Test
    public void testGetName() {
        String expected = "Dalston Library";
        Library library = new LibraryImpl(expected);
        assertEquals(expected, library.getName());
    }

    /**
     * Setting and then getting the maximum number of books per user returns
     * the correct value.
     */
    @Test
    public void testMaxBooksPerUser() {
        int expected = 10;
        Library library = new LibraryImpl("");
        library.setMaxBooksPerUser(expected);
        assertEquals(expected, library.getMaxBooksPerUser());
    }

    /**
     * Getting max books before setting succeed.
     *
     * getMaxBooksPerUser() should presumably return some default value if
     * setMaxBooksPerUser(int) hasn't already been called; in any case, it
     * should not throw an exception.
     */
    @Test
    public void testMaxBooksPerUserUnset() {
        Library library = new LibraryImpl("");
        library.getMaxBooksPerUser();        
    }
}