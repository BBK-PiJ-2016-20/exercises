public class IntegerTreeNode {
    private int value;
    private IntegerTreeNode left;
    private IntegerTreeNode right;

    public int getValue() {
        return value;
    }

    public IntegerTreeNode getLeft() {
        return left;
    }

    public IntegerTreeNode getRight() {
        return right;
    }

    public IntegerTreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void add(int newNumber) {
        if (newNumber > this.value) {
            if (right == null) {
                right = new IntegerTreeNode(newNumber);
            } else {
                right.add(newNumber);
            }
        } else {
            if (left == null) {
                left = new IntegerTreeNode(newNumber);
            } else {
                left.add(newNumber);
            }
        }
    }

    public boolean contains(int n) {
        if (n == this.value) {
            return true;
        } else if (n > this.value) {
            if (right == null) {
                return false;
            } else {
                return right.contains(n);
            }
        } else {
            if (left == null) {
                return false;
            } else {
                return left.contains(n);
            }
        }
    }

    public int getMax() {
        if (this.right == null) {
            return value;
        } else {
            return right.getMax();
        }
    }

    public int getMin() {
        if (this.left == null) {
            return value;
        } else {
            return left.getMin();
        }
    }

    public String toString() {
        String leftSide, rightSide;
        if (left != null) {
            leftSide = " " + left.toString();
        } else {
            leftSide = "";
        }
        if (right != null) {
            rightSide = " " + right.toString();
        } else {
            rightSide = "";
        }

        String printedTree = "[" + this.value + leftSide + rightSide + "]";
        return printedTree;
    }

}