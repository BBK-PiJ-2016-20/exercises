/**
 * A class representing the response of flying animals to the call to the ark.
 */
public class AirbourneResponse implements Response {
    @Override
    public String respond(Animal animal) {
        return animal.getName() + " now flying, will come later when tired...";
    }
}