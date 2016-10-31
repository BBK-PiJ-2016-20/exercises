public class Bear extends Mammal {
    public Bear() {
        super("Bear", new DefaultResponse());
    }

    @Override 
    public void makeSound() {
        printSoundString("growl");
    }
}