/**
 * An abstract base class for animals that reproduce by laying eggs.
 */
public abstract class Oviparous extends Animal {
    public Oviparous(String name, Response habitat) {
        super(name, habitat);
    }

    /**
     * Lay eggs
     */
    public void layEggs() {
        System.out.println(getName() + " has layed some eggs");
    }

    @Override
    public void reproduce() {
        layEggs();
    }
}