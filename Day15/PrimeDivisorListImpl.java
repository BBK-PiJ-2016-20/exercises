import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of PrimeDivisorList
 */
public class PrimeDivisorListImpl implements PrimeDivisorList {
    /**
     * This implementation works by storing a map of divisors to non-zero exponents.
     */
    private Map<Integer, Integer> exponents;

    public PrimeDivisorListImpl() {
        exponents = new HashMap<>();
    }

    @Override
    public void remove(Integer divisor) {
        Integer currentExponent = exponents.get(divisor);

        if (currentExponent == null) {
            return;
        }

        currentExponent--;
        // The map must only contain divisors with non-zero exponents, so if the
        // exponent drops to zero, the divisor must be removed.
        if (currentExponent == 0) {
            exponents.remove(divisor);
        } else {
            exponents.put(divisor, currentExponent);
        }
    }

    private static boolean isPrime(int toCheck) {
        int limit = (int) Math.sqrt(toCheck);
        int candidate = 2;
        while (candidate <= limit) {
            if (toCheck % candidate == 0) {
                return false;
            }
            candidate++;
        }
        return true;
    }

    @Override
    public void add(Integer divisor) {
        if (divisor == null) {
            throw new NullPointerException();
        }
        if (!isPrime(divisor)) {
            throw new IllegalArgumentException(divisor + " is not prime");
        }

        Integer currentExponent = exponents.get(divisor);
        if (currentExponent == null) {
            currentExponent = 1;
        } else {
            currentExponent++;
        }
        exponents.put(divisor, currentExponent);        
    }

    @Override
    public String toString() {
        if (exponents.isEmpty()) {
            return "[ 0 ]";
        }
        StringBuilder output = new StringBuilder("[ ");
        int product = 1;
        int base = 2;
        int counted = 0;

        while (counted < exponents.size()) {
            Integer exponent = exponents.get(base);
            if (exponent == null) {
                base++;
                continue;
            }

            product *= Math.pow(base, exponent);

            String component;

            if (exponent == 1) {
                component = String.valueOf(base);
            } else {
                component = base + "^" + exponent;
            }

            if (counted == 0) {
                output.append(component);
            } else {
                output.append(" * " + component);
            }

            counted++;
            base++;
        }

        output.append(" = " + product + " ]");

        return output.toString();
    }
}