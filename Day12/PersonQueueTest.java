import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class for testing implementations of the PersonQueue interface.
 */
public abstract class PersonQueueTest {
    protected abstract PersonQueue createQueue();

    /**
     * Test that retrive on an empty queue returns null
     */
    @Test
    public void testRetriveEmpty() {
        PersonQueue q = createQueue();
        assertNull(q.retrieve());
    }

    /**
     * Test that retrieve after insert retrieves the first inserted Person.
     */
    @Test
    public void testInsertRetrieve() {
        PersonQueue q = createQueue();
        Person p = new Person("Alice", 23);
        q.insert(p);
        assertSame(p, q.retrieve());
    }

    /**
     * Test that multiple retrieves after multiple asserts retrieve the Persons
     * in order of insertion.
     */
    @Test
    public void testManyInsertsRetrieves() {
        Person[] people = new Person[] {
            new Person("Alice", 23),
            new Person("Bob", 45),
            new Person("Claire", 15),
            new Person("David", 55),
            new Person("Eleanor", 37),
            new Person("Frank", 12)
        };

        PersonQueue q = createQueue();

        for (int i = 0; i < people.length; i++) {
            q.insert(people[i]);
        }

        for (int i = 0 ; i < people.length; i++) {
            assertSame(people[i], q.retrieve());
        }

    }

}