/**
  * Write a small program with a method that calculates the nth element of the
  * Fibonacci sequence as seen in the notes. Is it easy to do this both
  * iteratively and recursively? Try both ways and see which is more natural for
  * you. If one takes too long, try the other way. When doing it recursively, do
  * it with and without memoization. Compare the time that is needed in each
  * case to find F(40) or F(45).
  */

public class Fibonacci {

    public static int iterativeFibonacci(int n) {
        if (n < 3) {
            return 1;
        }

        int c = 3;
        // the c-1 th and c-2 th Fibonacci numbers
        int cMinus1 = 1, cMinus2 = 1;
        while (c < n) {
            int tmp = cMinus1;
            cMinus1 = cMinus1 + cMinus2;
            cMinus2 = tmp;
            c++;
        }
        return cMinus1 + cMinus2;
    }

    public static int recursiveFibonacci(int n) {
        if (n < 3) {
            return 1;
        }

        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    public static int memoFibonacci(int n, int[] memo) {
        if (memo[n-1] != 0) {
            return memo[n-1];
        }

        if (n < 3) {
            return 1;
        }

        memo[n-1] = memoFibonacci(n - 1, memo) + memoFibonacci(n - 2, memo);
        return memo[n-1]; 
    }

    public static void main(String[] args) {
        int n;
        if (args.length < 1) {
            n = 10;
        } else {
            n = Integer.parseInt(args[0]);
        }
        System.out.println(memoFibonacci(n, new int[n]));
        System.out.println(recursiveFibonacci(n));
        System.out.println(iterativeFibonacci(n));
    }
}