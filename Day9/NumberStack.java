public class NumberStack<T extends Number> {

    private static class NumberStackNode<T> {
        T data;
        NumberStackNode<T> next;
    }

    private NumberStackNode<T> head = null;

    /**
     * Add a value to the stack.
     */
    public void push(T value) {
        NumberStackNode<T> node = new NumberStackNode<T>();
        node.data = value;
        node.next = head;
        head = node;
    }

    /**
     * Return the value at the head of the stack without removing it,
     * or null if the stack is empty.
     */
    public T peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    /**
     * Return and remove the value at the head of the stack. Returns null if
     * the stack is empty.
     */
    public T pop() {
        if (head == null) {
            return null;
        }
        T ret = head.data;
        head = head.next;
        return ret;
    }

    public boolean isEmpty() {
        return head == null;
    }
}