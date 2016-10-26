public class Bear extends Mammal {
    public Bear() {
        super("Bear", new Response());
    }

    @Override 
    public void makeSound() {
        System.out.println("\"Growl\" growls the " + getName());
    }
}