/**
 * Create a class PrimeDivisorList. Integers (as in class Integer) can be added
 * to / removed from the list. If a null number is passed to the add(Integer)
 * method, a NullPointerException must be thrown. If a non-prime number is
 * added, an IllegalArgumentException must be thrown. Override the method
 * toString() so that it returns something like: [ 2 * 3^2 * 7 = 126 ] for a
 * list containing one 2, two 3, and one 7.
 */
 public interface PrimeDivisorList {
    /**
     * Add a divisor to the list.
     *
     * @param  divisor a divisor to add to the list. Throws
     * InvalidArgumentException if divisor is not a prime number, and
     * NullPointerException if divisor is null.
     */
    void add(Integer divisor);

    /**
     * Remove a divisor from the list.
     *
     * @param  divisor the divisor to remove. If this divisor is not in the
     * list, this method has no effect.
     */
    void remove(Integer divisor);

    /**
     * Represent this divisor list as an equation 
     */
    String toString();
 }