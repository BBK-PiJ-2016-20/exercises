/**
 * The greatest common divisor (GCD) of two natural numbers is the largest
 * natural number that can exactly divide them both. For example, the GCD of 12
 * and 15 is 3, the GCD of 12 and 6 is 6 (because both divisons 12/6 and 6/6 are
 * exact), and the greatest common divisor of 14 and 27 is 1.
 *
 * Finding the GCD of two numbers has a lot of applications in cryptography and
 * information security. We can find the GCD of two numbers by finding all of
 * them and them matching the lists for both numbers, but there is a fastest
 * way. The GCD has the property that
 *
 * if p > q, then gcd(p, q) = gcd(q, p mod q)
 *
 * where mod represents the modulo operator (i.e. %). Therefore, given two
 * numbers p and q, where p > q, if q is a divisor of p, then q is the GCD of
 * both number; otherwise, we can apply the property above to find a pair of
 * smaller numbers with the same GCD.
 *
 * Write a program that finds the GCD of two natural numbers recursively using
 * this property.
 */
public class Gcd {
    public static int gcd(int p, int q) {
        if (p < q) {
            int tmp = p;
            p = q;
            q = tmp;
        }
        
        if (p % q == 0) {
            return q;
        }

        return gcd(q, p % q);
    }

    public static void main(String[] args) {
        int p, q;
        if (args.length < 2) {
            p = 15;
            q = 12;
        } else {
            p = Integer.parseInt(args[0]);
            q = Integer.parseInt(args[1]);
        }

        System.out.println(gcd(p, q));
    }
}