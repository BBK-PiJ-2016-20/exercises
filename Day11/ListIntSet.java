public class ListIntSet implements IntSet {
    IntListNode head = null;

    public void add(int i) {
        if (head == null) {
            head = new IntListNode();
            head.value = i;
        } else {
            if (!contains(i)) {
                IntListNode newNode = new IntListNode();
                newNode.value = i;
                newNode.next = head;
                head = newNode;
            }
        }
    }

    public boolean contains(IntListNode node, int i, boolean verbose) {
        if (verbose) {
            System.out.println(node.value);
        }
        if (node.value == i) {
            return true;
        } 
        if (node.next == null) {
            return false;
        }

        return contains(node.next, i, verbose);
    }

    public boolean contains(int i) {
        if (head == null) {
            return false;
        }
        return contains(head, i, false);
    }

    public boolean containsVerbose(int i) {
        if (head == null) {
            return false;
        }

        return contains(head, i, true);
    }

    private String toString(IntListNode node) {
        if (node.next == null) {
            return String.valueOf(node.value);
        } 

        return String.valueOf(node.value) + "," + toString(node.next);
    }

    public String toString() {
        if (head == null) {
            return "";
        }
        return toString(head);
    }
}