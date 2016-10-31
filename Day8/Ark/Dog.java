public class Dog extends Mammal {
    public Dog() {
        super("Dog", new DefaultResponse());
    }

    @Override
    public void makeSound() {
        printSoundString("bark");
    }
}