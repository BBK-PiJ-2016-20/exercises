public interface Stack<T> {
    /**
     * Add an element to the top of the stack.
     *
     * @param   t   the element to add.
     */
    void push(T t);

    /**
     * Removes the element at the top of the stack and returns it.
     *
     * @returns the element removed from the stack, or null if the stack is
     *          empty.
     */
    T pop();

    /**
     * Returns the element from the top of the stack, but does not remove it.
     *
     * @returns the top element on the stack, or null if the stack is empty.
     */
    T peek();

    /**
     * Returns true if there are not elements on the stack, false otherwise.
     */
    boolean isEmpty();
}