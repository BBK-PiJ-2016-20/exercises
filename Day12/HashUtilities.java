public class HashUtilities {
    public static int shortHash(int i) {
        return Math.abs(i % 999) + 1;
    }
}