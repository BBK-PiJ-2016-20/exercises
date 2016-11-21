/**
 * An implementation of the Library interface.
 */
public class LibraryImpl implements Library {

    private String name;
    private int maxBooksPerUser;

    public LibraryImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId(String username) { 
        return -1; 
    }

    @Override
    public int getMaxBooksPerUser() {
        return maxBooksPerUser;
    }

    @Override
    public void setMaxBooksPerUser(int maxBooksPerUser) {
        this.maxBooksPerUser = maxBooksPerUser; 
    }
}