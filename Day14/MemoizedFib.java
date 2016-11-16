public class MemoizedFib {
    /**
     * Return the nth Fibonacci number. Can calculate up to F(92) before the
     * long overflows (a previous version returning int could calculate up to
     * F(46) before int overflow).
     */
    public static long fib(int n) {        
        // Create a memo array to store up to the nth Fibonacci number
        long[] memo = new long[n];
        memo[0] = 1; // 1st Fibonacci number is 1;
        memo[1] = 1; // as is the second
        for (int i = 2; i < n; i++) {
            memo[i] = -1;
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
    private static long fib(int n, long[] memo) {
        if (memo[n-1] != - 1) {
            return memo[n-1];
        }
        long nth = fib(n - 1, memo) + fib(n - 2, memo);
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

        System.out.println("        " + Long.MAX_VALUE);
        System.out.println("F(" + n + ") = " + fib(n));
    }
}