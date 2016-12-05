import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of the Library interface.
 */
public class LibraryImpl implements Library {

    private String name;
    private int maxBooksPerUser;
    private int maxId;
    private Map<String, Integer> ids;

    public LibraryImpl(String name) {
        this.name = name;
        this.maxId = 0;
        this.ids = new HashMap<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId(String username) {
        Integer id = ids.get(username);        
        if (id != null) {
            return id;
        } else {
            maxId++;
            ids.put(username, maxId);
            return maxId;
        } 
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