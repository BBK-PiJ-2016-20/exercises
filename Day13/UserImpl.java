/**
 * An implementation of the User interface.
 */
public class UserImpl implements User {

    private String name;
    private Library library;

    /**
     * Create a UserImpl with the specified name.
     */
    public UserImpl(String name) { 
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() { 
        if (library == null) {
            throw new NotRegisteredException();
        }
        return library.getId(this.name); 
    }

    @Override
    public String getLibrary() {
        if (library == null) {
            throw new NotRegisteredException();
        }
        return library.getName();
    }

    @Override
    public void register(Library library) {
        this.library = library;
    }
}