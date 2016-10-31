public class Cat extends Mammal {
    public Cat() {
        super("Cat", new DefaultResponse());
    }

    @Override
    public void makeSound() {
        printSoundString("miaow");
    }
}