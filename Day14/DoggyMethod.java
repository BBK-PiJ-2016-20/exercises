public class DoggyMethod {
    public static String doggyMethod(int n) {
        // The original code had line A here, which recursively called the
        // method before checking for the condition, leading to infinite
        // recursion.
        if (n <= 0) {
            return "";
        }
        String result = doggyMethod(n - 3) + n + doggyMethod(n - 2); // A
        return result;
    }

    public static void main(String[] args) {
        int n;
        if (args.length < 1) {
            n = 10;
        } else {
            n = Integer.parseInt(args[0]);
        }
        System.out.println(doggyMethod(n));
    }
}