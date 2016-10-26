/**
 * An abstract class for animals. Animals can be called to the ark, can reproduce, and can make a sound.
 */
public abstract class Animal {
    private Response response;
    private String name;

    public Animal(String name, Response response) {
        this.name = name;
        this.response = response;
    }

    /** 
     * Reproduce the animal in whatever way is appropriate
     */
    public abstract void reproduce();

    /** 
     * Call the animal to the ark (the specifics of what the animal does when
     * called are delegated to the Habitat class).
     */
    public void call() {
        System.out.println(response.respond(this));
    }

    /**
     * Make the animal's characteristic sound.
     */
    public abstract void makeSound();

    /**
     * Return the species name of the animal.
     *
     * @return the species.
     */
    public String getName() {
        return name;
    } 
}