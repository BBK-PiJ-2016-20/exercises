public class TreeIntSet implements IntSet {

    IntegerTreeNode root = null;

    public void add(int i) {
        if (root == null) {
            root = new IntegerTreeNode(i);
        } else {
            if (!contains(i)) {
                root.add(i);
            }
        }
    }

    public boolean contains(int i) {
        if (root == null) {
            return false;
        }
        return root.contains(i);
    }

    public boolean containsVerbose(int i) {
        return containsVerbose(root, i);
    }

    public boolean containsVerbose(IntegerTreeNode node, int i) {
        System.out.println(node.getValue());

        if (node.getValue() == i) {
            return true;
        }

        if (i > node.getValue()) {
            if (node.getRight() == null) {
                return false;
            }
            return containsVerbose(node.getRight(), i);
        } else {
            if (node.getLeft() == null) {
                return false;
            }

            return containsVerbose(node.getLeft(), i);
        }
    }

    public String toString() {
        return toString(root);
    }

    public String toString(IntegerTreeNode node) {
        String leftSide, rightSide;

        if (node.getLeft() == null) {
            leftSide = "";
        } else {
            leftSide = ", " + toString(node.getLeft());
        }

        if (node.getRight() == null) {
            rightSide = "";
        } else {
            rightSide = ", " + toString(node.getRight());
        }

        return node.getValue() + leftSide + rightSide;
    }
}