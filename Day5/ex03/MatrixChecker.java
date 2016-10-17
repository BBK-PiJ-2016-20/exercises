class MatrixChecker {
    public static boolean isSymmetrical(int[] ints) {
        for (int i = 0; i < (ints.length / 2); i++) {
            if (ints[i] != ints[ints.length - i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isSymmetrical(int[][] ints) {
        for (int i = 0; i < ints.length; i++) {
            if (ints[i].length != ints.length) {
                // For a matrix to be symmetrical, it must be square.
                return false;
            }
            for (int j = 0; j < ints[i].length; j++) {
                if (ints[i][j] != ints[j][i]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isTriangular(int[][] ints) {
        for (int i = 0; i < ints.length; i++) {
            if (ints[i].length != ints.length) {
                return false;
            }
            for (int j = 0; j < ints[i].length; j++) {
                if (i > j && ints[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}