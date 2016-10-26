/**
 * A base class for mammals, which reproduce by giving birth.
 */
 public abstract class Mammal extends Animal {
     public Mammal(String name, Response habitat) {
         super(name, habitat);
     }

     /**
      * Give birth to live young.
      */
     public void giveBirth() {
         System.out.println(getName() + " has given birth");
     }

     @Override
     public void reproduce() {
         giveBirth();
     }
 }