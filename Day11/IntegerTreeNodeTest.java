public class IntegerTreeNodeTest {
    public static void main(String[] args) {
        IntegerTreeNode tree = new IntegerTreeNode(5);
        System.out.println("Should be 5: " + tree.getMax());
        System.out.println("Should be 5: " + tree.getMin());
        tree.add(3);
        tree.add(2);
        tree.add(7);
        tree.add(8);
        tree.add(4);
        System.out.println("Should be 8: " + tree.getMax());
        System.out.println("Should be 2: " + tree.getMin());
        System.out.println("Should be true: " + tree.contains(2));        
        System.out.println("Should be false: " + tree.contains(10));        
    }
}