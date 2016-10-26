/**
 * An attempt to inherit from a final class. Does not compile.
 */
class EvenString extends String {
    /**
     * Prints the even-numbered characters of the string.
     */
    void printEven() {
        for (int i = 0; i < length(); i += 2) {
            System.out.print(charAt(i));
        }
    }
}