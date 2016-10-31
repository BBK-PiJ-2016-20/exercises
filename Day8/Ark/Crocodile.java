public class Crocodile extends Oviparous {
    public Crocodile() {
        // A crocodile is amphibious; should it count as aquatic for this
        // purpose? Can it survive for long periods entirely in the water?
        super("Crocodile", new AquaticResponse());
    }

    @Override
    public void makeSound() {
        printSoundString("snap");
    }
}