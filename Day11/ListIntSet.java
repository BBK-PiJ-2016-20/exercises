public class ListIntSet implements IntSet {
    IntListNode head = null;

    public void add(int i) {
        if (head == null) {
            head = new IntListNode();
            head.value = i;
        } else {
            if (!contains(i)) {
                newNode = new IntListNode();
                newNode.value = i;
                newNode.next = head;
                head = newNode;
            }
        }
    }
}