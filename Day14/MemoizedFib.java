import java.math.BigInteger;

public class MemoizedFib {
    /**
     * Return the nth Fibonacci number.
     */
    public static BigInteger fib(int n) {        
        // Create a memo array to store up to the nth Fibonacci number
        BigInteger[] memo = new BigInteger[n];
        memo[0] = new BigInteger("1"); // 1st Fibonacci number is 1;
        memo[1] = new BigInteger("1"); // as is the second
        for (int i = 2; i < n; i++) {
            memo[i] = new BigInteger("-1");
        }
        
        return fib(n, memo);
    } 

    /**
     * Return the nth Fibonacci number, using the supplied array for
     * memoization. 
     * 
     * @param   n       which Fibonacci number to calculate.
     * @param   memo    an array used for memoization. Must have a length of at least n.
     */
    private static BigInteger fib(int n, BigInteger[] memo) {
        if (!memo[n-1].equals(new BigInteger("-1"))) {
            return memo[n-1];
        }
        BigInteger nth = fib(n - 1, memo).add(fib(n - 2, memo));
        memo[n - 1] = nth;
        return nth;
    } 

    public static void main(String[] args) {
        int n;
        if (args.length < 1) {
            n = 10;
        } else {
            n = Integer.parseInt(args[0]);
        }

        System.out.println("F(" + n + ") = " + fib(n));
    }
}