public class Beetle extends Oviparous {
    public Beetle() {
        super("Beetle", new AirbourneResponse())
    }

    @Override 
    public void makeSound() {
        printSoundString("chitter");
    }
}