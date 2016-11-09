/**
 * Tests the methods defined on the Stack interface. Intended to be subclassed
 * to test concrete implementations of the interface.
 *
 * I'm only testing Stack<Object> (rather than testing Stack<T>) generically,
 * because the tests need to be able to create instances of the contained class.
 */

import org.junit.Test;
import static org.junit.Assert.*;

public abstract class StackTest {
    /**
     * Create an instance of the concrete stack implementation being tested.
     */
    protected abstract Stack<Object> createStack();

    /**
     * Create a stack with one object in it.
     */
     protected Stack<Object> createStackOne() {
         Stack<Object> s = createStack();
         s.push(new Object());
         return s;
     }

     /**
      * Create a stack with many objects on it
      */
     protected Stack<Object> createStackMany() {
         Stack<Object> s = createStack();
         for (int i = 0; i < 1000; i++) {
             s.push(new Object());
         }
         return s;
     }


    /** 
     * Test that isEmpty() is true for a newly-created stack.
     */
    @Test 
    public void testNewIsEmpty() {
        assertTrue(createStack().isEmpty());
    }

    /**
     * Test that after something is pushed onto a stack, the stack is no longer
     * empty.
     */
    @Test
    public void testPushNotEmpty() {
        Stack<Object> s = createStack();
        s.push(new Object());
        assertFalse(s.isEmpty());
    }

    /**
     * Test that pop on an empty stack is null.
     */
    @Test
    public void testPopEmpty() {
        Stack<Object> s = createStack();
        assertNull(s.pop());
    }

    /**
     * Test that a push and a pop on an empty stack leaves an empty stack.
     */
    @Test
    public void testPopToEmpty() {
        Stack<Object> s = createStack();
        s.push(new Object());
        s.pop();
        assertTrue(s.isEmpty());
    }

    /**
     * Test that a push and a pop on a stack with one element leaves a non-empty
     * stack.
     */
    @Test
    public void testPopToOne() {
        Stack<Object> s = createStackOne();
        s.push(new Object());
        s.pop();
        assertFalse(s.isEmpty());
    }

    /**
     * Test that a push and a pop on a stack with one element leaves a non-empty
     * stack.
     */
    @Test
    public void testPopToMany() {
        Stack<Object> s = createStackMany();
        s.push(new Object());
        s.pop();
        assertFalse(s.isEmpty());
    }


    /**
     * Test that pop after push returns the object that was pushed, on an empty
     * stack.
     */
    @Test
    public void testPushPopEmpty() {
        Stack<Object> s = createStack();
        Object o = new Object();
        s.push(o);
        assertSame(o, s.pop());
    }

    /**
     * Tests that pop after push returns the object that was pushed, on a
     * stack with one element.
     */
    @Test
    public void testPushPopOne() {
        Stack<Object> s = createStackOne();
        Object o = new Object();
        s.push(o);
        assertSame(o, s.pop());
    }

    /**
     * Tests that pop after push returns the object that was pushed, on a
     * stack with many elements.
     */
    @Test
    public void testPushPopMany() {
        Stack<Object> s = createStackMany();
        Object o = new Object();
        s.push(o);
        assertSame(o, s.pop());
    }

    /**
     * Test that pushing an element, then popping that element, then popping
     * another element does not return the element that was added, on a stack
     * with one element.
     */
    @Test
    public void testPushPopPopOne() {
        Stack<Object> s = createStackOne();
        Object o = new Object();
        s.push(o);
        s.pop();
        assertNotSame(o, s.pop());
    }

    /**
     * Test that pushing an element, then popping that element, then popping
     * another element does not return the element that was added, on a stack
     * with many elements.
     */
    @Test
    public void testPushPopPopMany() {
        Stack<Object> s = createStackMany();
        Object o = new Object();
        s.push(o);
        s.pop();
        assertNotSame(o, s.pop());
    }

    /**
     * Test that peek on an empty stack is null.
     */
    @Test
    public void testPeekEmpty() {
        Stack<Object> s = createStack();
        assertNull(s.peek());
    }

    /**
     * Test that push then peek on an empty stack does not leave the stack
     * empty.
     */
    @Test
    public void testPeekDoesNotRemove() {
        Stack<Object> s = createStack();
        s.push(new Object());
        s.peek();
        assertFalse(s.isEmpty());
    }

    /**
     * Test that push then peek returns the object pushed, on an empty stack.
     */
    @Test
    public void testPushPeekEmpty() {
        Stack<Object> s = createStack();
        Object o = new Object();
        s.push(o);
        assertSame(o, s.peek());
    }

    /**
     * Test that push then peek returns the object pushed, on a stack with one
     * element.
     */
    @Test
    public void testPushPeekOne() {
        Stack<Object> s = createStackOne();
        Object o = new Object();
        s.push(o);
        assertSame(o, s.peek());
    }

    /**
     * Test that push then peek returns the object pushed, on a stack with many
     * elements.
     */
    @Test
    public void testPushPeekMany() {
        Stack<Object> s = createStackMany();
        Object o = new Object();
        s.push(o);
        assertSame(o, s.peek());
    }

    /**
     * Test that, after a push and a pop, peek does not return the element
     * pushed, on a stack with one element.
     */
    @Test
    public void testPushPopPeekOne() {
        Stack<Object> s = createStackOne();
        Object o = new Object();
        s.push(o);
        s.pop();
        assertNotSame(o, s.peek());
    }

    /**
     * Test that, after a push and a pop, peek does not return the element
     * pushed, on a stack with many elements.
     */
    @Test
    public void testPushPopPeekMany() {
        Stack<Object> s = createStackMany();
        Object o = new Object();
        s.push(o);
        s.pop();
        assertNotSame(o, s.peek());
    }
}