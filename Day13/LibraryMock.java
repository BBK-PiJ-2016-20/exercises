/**
 * A mock implementation of the Library interface for testing.
 */
public class LibraryMock implements Library {

    private String name;
    private int fakeId;

    /**
     * Create a LibraryMock with the given name, which will return the given
     * id to all requests for an ID.
     */
    public LibraryMock(String name, int fakeId) {
        this.name = name; 
        this.fakeId = fakeId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId(String username) {
        return fakeId;
    }
}