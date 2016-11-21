import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test the implementation of User
 */
public class UserImplTest {
    /**
     * getName returns the name set in the constructor.
     */
    @Test
    public void testGetName() {
        String expected = "CLR James";
        User user = new UserImpl(expected);
        assertEquals(expected, user.getName());
    }

    /**
     * Registering with a library sets the id.
     */
    @Test
    public void testRegister() {
        int expected = 10;
        Library library = new LibraryMock("", expected);
        User user = new UserImpl("CLR James");
        user.register(library);
        assertEquals(expected, user.getId());
    }

    /**
     * After registering, getLibrary() returns the library name.
     */
    @Test
    public void testGetLibrary() {
        String expected = "Dalston Library";
        Library library = new LibraryMock(expected, 0);
        User user = new UserImpl("CLR James");
        user.register(library);
        assertEquals(expected, user.getLibrary());
    }

    /**
     * Trying to get the ID of a user prior to registering with a library
     * throws a NotRegisteredException.
     */
    @Test(expected = NotRegisteredException.class)
    public void testGetIdUnregistered() {
        User user = new UserImpl("CLR James");
        user.getId();
    }

    /**
     * Trying to get library name of a user prior to registering with a librar
     * throws a NotRegisteredException.
     */
    @Test(expected = NotRegisteredException.class)
    public void testGetLibraryUnregistered() {
        User user = new UserImpl("CLR James");
        user.getLibrary();        
    }
    
}