/**
 *Create a class with a method pow that takes two integers (base and exponent)
 *and calculates the power, e.g. pow(2,3) calculates 23.
 *
 *Is it easy to do this both iteratively and recursively?
 */
class Power {
    public static int pow(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        return base * pow(base, exponent - 1);
    }

    public static int powIterative(int base, int exponent) {
        int result = 1;
        while (exponent > 0) {
            result *= base;
            exponent--;
        }
        return result;
    }

    public static void main(String[] args) {
        int base, exponent;
        if (args.length < 2) {
            base = 2;
            exponent = 3;
        } else {
            base = Integer.parseInt(args[0]);
            exponent = Integer.parseInt(args[1]);
        }

        System.out.println(pow(base, exponent));
        System.out.println(powIterative(base, exponent));
    }
}