import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the implementation of PrimeDivisorList
 */
public class PrimeDivisorListImplTest {
    /**
     * Adding a prime number to a PrimeDivisorList succeed.
     */
    @Test
    public void testAddPrime() {
        PrimeDivisorList list = new PrimeDivisorListImpl();
        list.add(2);
    }

    /**
     * Adding multiple primes to a PrimeDivisorList succeeds.
     */
    @Test
    public void testAddManyPrimes() {
        PrimeDivisorList list = new PrimeDivisorListImpl();
        list.add(2);        
        list.add(3);        
        list.add(5);        
    }

    /**
     * Adding the same prime more than once succeeds.
     */
    @Test
    public void testAddPrimeAgain() {
        PrimeDivisorList list = new PrimeDivisorListImpl();
        list.add(2);        
        list.add(2);        
        list.add(2);                
    }

    /**
     * Adding a non-prime to a PrimeDivisorList throws IllegalArgumentException.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testAddNonPrime() {
        PrimeDivisorList list = new PrimeDivisorListImpl();
        list.add(4);
    }

    /**
     * Adding a null to a PrimeDivisorList throws NullPointerException.
     */
    @Test(expected=NullPointerException.class) 
    public void testAddNull() {
        PrimeDivisorList list = new PrimeDivisorListImpl();
        list.add(null);
    }

    /**
     * Remove a prime number succeeds.
     */
    @Test
    public void testRemovePrime() {
        PrimeDivisorList list = new PrimeDivisorListImpl();
        list.add(3);
        list.remove(3);
    }

    /**
     * Remove from an empty list succeeds (i.e., does nothing with no error).
     */
    @Test
    public void testRemoveEmpty() {
        PrimeDivisorList list = new PrimeDivisorListImpl();
        list.remove(3);
    }

    /**
     * Removing a non-prime succeeds (i.e., does nothing with no error).
     */
    @Test
    public void testRemoveNonPrime() {
        PrimeDivisorList list = new PrimeDivisorListImpl();
        list.remove(4);
    }

    /**
     * toString on an empty list.
     */
    @Test
    public void testToStringEmpty() {
        PrimeDivisorList list = new PrimeDivisorListImpl();
        assertEquals("[ 0 ]", list.toString());
    }

    /**
     * toString on a list with one element.
     */
    @Test
    public void testToStringOne() {
        PrimeDivisorList list = new PrimeDivisorListImpl();
        list.add(2);
        assertEquals("[ 2 = 2 ]", list.toString());
    }

    /**
     * toString on a list with a repeated element.
     */
    @Test
    public void testToStringRepeated() {
        PrimeDivisorList list = new PrimeDivisorListImpl();
        list.add(2);
        list.add(2);
        assertEquals("[ 2^2 = 4 ]", list.toString());        
    }

    /**
     * toString on a list with multiple single elements.
     */
    @Test
    public void testToStringMultiple() {
        PrimeDivisorList list = new PrimeDivisorListImpl();
        list.add(2);
        list.add(3);
        assertEquals("[ 2 * 3 = 6 ]", list.toString());
    }

    /**
     * toString on a complex list.
     */
    @Test
    public void testToStringComplex() {
        PrimeDivisorList list = new PrimeDivisorListImpl();
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(7);
        assertEquals("[ 2 * 3^2 * 7 = 126 ]", list.toString());
    }

    /**
     * toString() after remove one.
     */
    @Test
    public void testToStringRemoveOne() {
        PrimeDivisorList list = new PrimeDivisorListImpl();
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(7);
        list.remove(2);
        assertEquals("[ 3^2 * 7 = 63 ]", list.toString());        
    }

    /**
     * toString() after remove many.
     */
    @Test
    public void testToStringRemoveMany() {
        PrimeDivisorList list = new PrimeDivisorListImpl();
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(7);
        list.remove(2);
        list.remove(3);
        assertEquals("[ 3 * 7 = 21 ]", list.toString());        
    }

    /**
     * toString() after removing a divisor that was not present.
     */
     /**
     * toString on a complex list.
     */
    @Test
    public void testToStringMissing() {
        PrimeDivisorList list = new PrimeDivisorListImpl();
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(7);
        list.remove(5);
        assertEquals("[ 2 * 3^2 * 7 = 126 ]", list.toString());
    }
    


}