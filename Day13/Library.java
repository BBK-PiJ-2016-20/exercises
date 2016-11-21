/**
 * An interface representing a library, which manages users and books.
 */
public interface Library {
    /**
     * Returns the library's name
     */
    String getName();

    /**
     * Returns the ID of the given user. If the user has not previously
     * registered with the library, a new ID is created.
     */
    int getId(String user);

    /**
     * Set the maximum number of books per user.
     */
    void setMaxBooksPerUser(int i);

    /**
     * Get the maximum number of books per user.
     */
    int getMaxBooksPerUser();
}