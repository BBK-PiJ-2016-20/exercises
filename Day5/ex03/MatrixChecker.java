/*
Make a class MatrixChecker with three methods:
*/

class MatrixChecker {

    /*
    isSymmetrical(int[]) takes an array of int and returns true if the array is symmetrical and false otherwise.
    An array is symetrical if the element at [0] is the same as the element at [length-1], the element at [1] is the
    same as the element at [length-2], etc.
    */
    public static boolean isSymmetrical(int[] ints) {
        for (int i = 0; i < (ints.length / 2); i++) {
            if (ints[i] != ints[ints.length - i - 1]) {
                return false;
            }
        }

        return true;
    }

    /*
    isSymmetrical(int[][]) takes an bidimensional array of int and returns true if the matrix is symmetrical
    and false otherwise. An matrix is symmetrical if m[i][j] == m[j][i] for any value of i and j.
    */
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

    /*
    isTriangular(int[][]) takes an bidimensional array of int and returns true if the matrix is triangular
    and false otherwise. An matrix is triangular if m[i][j] == 0 for any value of i that is greater than j.
    */
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