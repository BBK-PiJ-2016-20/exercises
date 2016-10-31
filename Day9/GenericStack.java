public class GenericStack<T extends Number> {
    private GenericStackNode<T> head = null;

    public void push(T value) {
        GenericStackNode<T> node = new GenericStackNode<T>();
        node.data = value;
        node.next = head;
        head = node;
    }

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