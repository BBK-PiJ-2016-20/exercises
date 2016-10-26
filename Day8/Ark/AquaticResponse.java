/**
 * A class representing the response of aquatic animals to the call.
 */
public class AquaticResponse extends Response {
    @Override
    public void respond(Animal animal) {
        return animal.getName() + " will not come...";
    }
}