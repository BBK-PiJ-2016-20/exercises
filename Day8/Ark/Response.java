/**
 * A class representing a (type of) animal's response to the call to the ark.
 */
public class Response {
    /**
     * Processes the supplied animal's response to the call to the ark.
     *
     * @param   animal  the animal that has been called to the ark
     * @return  the animal's response to the call
     */
    public String respond(Animal animal) {
        return animal.getName() + " coming...";
    }
}