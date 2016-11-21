/**
 * An interface to represent library users
 */
public interface User {
    /**
     * Return the user's name.
     */
    String getName();

    /**
     * Return the user's library ID.
     */
    int getId();

    /**
     * Get the name of the library that this user is registered with.
     */
    String getLibrary();

    /**
     * Register with, and obtain an ID from, a library.
     */
    void register(Library library);
}