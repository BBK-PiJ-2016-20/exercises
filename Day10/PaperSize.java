/*
 * A Din-A0 sheet of paper is 841mm × 1189mm (its surface is one square meter).
 * Successive measurements of paper are defined recursively as "half" or
 * "double"" the preceding size. Therefore, a Din-A1 sheet of paper is half of
 * Din-A0, or 594mm × 841mm; while a Din-A00 is double of Din-A0, or 1189mm×
 * 1682mm. Create a method that takes a String parameter representing a size
 * (e.g. "A4", "A00000"") and prints on screen the size of the corresponding
 * sheet of paper. For simplicity, you can ignore rounding errors when
 * calculating smaller sizes.
 */
public class PaperSize {
    public static class Dimensions {
        double longSide;
        double shortSide;

        public Dimensions(double longSide, double shortSide) {
            this.longSide = longSide;
            this.shortSide = shortSide;
        }
    }

    /**
     * Returns the dimensions of the paper size stepsSmaller steps smaller than
     * the given paper size.
     */
    private static Dimensions smallerSize(Dimensions d, int stepsSmaller) {
        if (stepsSmaller == 0) {
            return d;
        }
        return smallerSize(new Dimensions(d.shortSide, d.longSide / 2), stepsSmaller - 1);
    }

    /**
     * Returns the dimensions of the paper size stepsLarger steps larger than
     * the given paper size.
     */
    private static Dimensions largerSize(Dimensions d, int stepsLarger) {
        if (stepsLarger == 0) {
            return d;
        }

        return largerSize(new Dimensions(d.shortSide * 2, d.longSide), stepsLarger - 1);
    }

    // The dimensions of A0 paper, used to calculate all the other dimensions.
    private static final Dimensions A0 = new Dimensions(1189, 841);

    /**
     * Return the size of the paper corresponding to the given description
     * string (e.g. A00, A4), or null if the description string is invalid.
     */
    public static Dimensions paperSize(String description) {
        if (description.length() < 2 || description.charAt(0) != 'A') {
            return null;
        }
        if (description.charAt(1) == '0') {
            if (! allZeros(description.substring(1))) {
                return null;
            }
            return largerSize(A0, description.length() - 2);
        } else {
            if (! allDigits(description.substring(1))) {
                return null;
            }
            return smallerSize(A0, Integer.parseInt(description.substring(1)));
        }
    }

    /**
     * Returns true if the supplied string contains only the character '0', false otherwise.
     */
    private static boolean allZeros(String s) {
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0')
                return false;
        }

        return true;
    }

    /** 
     * Returns true if the supplied string contains only digits, false otherwise.
     */
    private static boolean allDigits(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s;
        if (args.length < 1) {
            s = "A1";
        } else {
            s = args[0];
        }

        Dimensions d = paperSize(s);
        if (d == null) {
            System.out.println(s + " is not a valid paper size");
        } else {
            System.out.println(d.shortSide + "mm x " + d.longSide + "mm");
        }
    } 
}