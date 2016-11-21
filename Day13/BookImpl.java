/**
 * An implementation of the Book interface.
 */
public class BookImpl implements Book {

    private String author;
    private String title;

    public BookImpl(String author, String title) {
        this.author = author;
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }
}