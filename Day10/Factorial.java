/*
 * Write a small program with a method that calculates the factorial of an
 * integer number as seen in the notes. Is it easy to do this both iteratively
 * and recursively? Try both ways and see which is more natural for you. If one
 * takes too long, try the other way.
 */
public class Factorial {
    public static int iterativeFactorial(int n) {
        int result = 1;
        while (n > 0) {
            result *= n;
            n--;
        }

        return result;
    }

    public static int recursiveFactorial(int n) {
        if (n <= 0) {
            return 1;
        }
        return n * recursiveFactorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(iterativeFactorial(10));
        System.out.println(recursiveFactorial(10));
    }
}