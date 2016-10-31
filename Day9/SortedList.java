/**
 * A linked list that keeps its contents in ascending order
 */
public class SortedList<T extends Comparable<T>> extends DoublyLinkedList<T> {
    @Override
    public void add(T t) {
        DoublyLinkedNode<T> node = new DoublyLinkedNode<T>();
        node.data = t;
        
        if (first == null) {
            node.next = null;
            node.prev = null;
            first = node;
            return; 
        } 

        if (t.compareTo(first.data) < 0) {
            node.prev = null;
            node.next = first;
            node.next.prev = node;
            first = node;
            return;
        }

        DoublyLinkedNode<T> current = first;
        while (current.next != null && t.compareTo(current.next.data) > 0) {
            current = current.next;
        }

        node.prev = current;
        node.next = current.next;
        if (current.next != null) {
            current.next.prev = node;
        }
        current.next = node;
    }
}