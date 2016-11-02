public class BuggyMethod {
    public static String buggyMethod(int n) {
        // Because the recursive call subtracts 2, if the method is called with
        // an odd number, subsequent calls will never have n == 0; n will go from 
        // 1 to -1.
        if (n == 0) {
            return "";
        }
        return n + " " + buggyMethod(n - 2);
    }

    public static String fixedMethod(int n) {
        // To fix the problem in buggyMethod, check for n <= 0 rather than n == 0
        if (n <= 0) {
            return "";
        }
        return n + " " + fixedMethod(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fixedMethod(11));
    }
}