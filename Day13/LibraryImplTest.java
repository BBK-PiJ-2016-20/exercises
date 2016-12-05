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

    /**
     * Repeated calls to getId(String) with the same name should return the
     * same ID.
     */
    @Test
    public void testGetIdSameName() {
        Library library = new LibraryImpl("");
        String name = "CLR James";
        assertEquals(library.getId(name), library.getId(name));
    }

    /**
     * Calls to getId(String) with different names should return different
     * IDs.
     */
    @Test
    public void testGetIdDifferenceName() {
        Library library = new LibraryImpl("");
        assertNotEquals(library.getId("CLR James"), library.getId("Raya Dunayevskaya"));
    }
}