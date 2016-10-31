/**
 * A class representing the standard animal's response to the call to the ark.
 */
public class DefaultResponse implements Response{
    public String respond(Animal animal) {
        return animal.getName() + " coming...";
    }
}