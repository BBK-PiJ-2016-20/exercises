/**
 * Write a method that calculates the maximum size of the stack (measured in
 * method calls) by forcing a StackOverflowError. Use different version of your
 * method, each of them with a different number and different types of local
 * variables, and see how the number of maximum function calls changes depending
 * on that.
*/

public class StackSize {

    private static int depth;

    private static void unbounded() {
        depth++;        
        unbounded();
    }

    private static void unboundedWithIntArg(int n) {
        depth++;        
        unboundedWithIntArg(n + 1);
    }


    private static void unboundedWithIntLocal() {
        int local = depth + 1;
        depth++;
        unboundedWithIntLocal();
    }

    private static void unboundedWithDoubleLocal() {
        double d = (double) depth;
        depth++;
        unboundedWithDoubleLocal();
    }

    private static void unboundedWithComplexLocal() {
        StackSize s = null;
        depth++;
        unboundedWithComplexLocal();
    }

    public static void main(String[] args) {
        depth = 0;
        try {
            unbounded();
        } catch (java.lang.StackOverflowError e) {
            System.out.println("No local variables or argument: " + depth);
        }

        depth = 0;
        try {
            unboundedWithIntArg(1);
        } catch (java.lang.StackOverflowError e) {
            System.out.println("With an int argument: " + depth);
        }

        depth = 0;
        try {
            unboundedWithIntLocal();
        } catch (java.lang.StackOverflowError e) {
            System.out.println("With an int local: " + depth);
        }

        depth = 0;
        try {
            unboundedWithDoubleLocal();
        } catch (java.lang.StackOverflowError e) {
            System.out.println("With a double local: " + depth);
        }

        depth = 0;
        try {
            unboundedWithComplexLocal();
        } catch (java.lang.StackOverflowError e) {
            System.out.println("With a complex local: " + depth);
        }

    }
}