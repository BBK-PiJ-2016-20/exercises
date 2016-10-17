/* Create a class Matrix that has a 2-D array of integers as a field */
public class Matrix {
    private int[][] values;

    /* a constructor method Matrix(int,int) setting the size of the array as two integers (not necessarily the
    same). All elements in the matrix should be initialised to 1. */
    public Matrix(int rows, int cols) {
        values = new int[rows][cols];
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                values[i][j] = 1;
            }
        }
    }

    // Return the number of rows in the matrix
    public int getRows() {
        return values.length;
    }

    // Return the number of columns in the matrix. Only works if the matrix has more than 0 rows.
    public int getCols() {
        return values[0].length;
    }


    /* a method setElement(int,int,int) to modify one element of the array, given its position (the first two
       integers) and the new value to be put in that position (the third integer). The method must check that the
       indeces are valid before modifying the array to avoid an IndexOutOfBoundsException. If the indeces are
       invalid, the method will do nothing and the third argument will be ignored. */
    public void setElement(int row, int col, int value) {
        if (row < getRows() && col < getCols()) {
            values[row][col] = value;
        } else {
            System.err.println("Warning: row or column out of bounds in setElement");
        }
    }

    // Checks if a string contains only digit characters 
    private static boolean isAllDigits(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (! Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    // Split a string on the given character, returning an array of strings (not including the separator). If there
    // are not exactly count elements in the resulting array, return an empty array.
    private static String[] split(String str, char separator, int count) {
        String[] ret = new String[count];
        String currentString = "";
        int currentIndex = 0;

        str = str + separator;

        int i = 0;
        while (i < str.length() && currentIndex < count) {
            char c = str.charAt(i);
            if (c == separator) {
                ret[currentIndex] = currentString;
                currentString = "";
                currentIndex++;
            } else {
                currentString += c;
            }
            i++;
        }

        // If we have read the whole string and have got exactly the right number of elements, we can return
        // the list. Otherwise, return an empty array to signify an error.
        if (i == str.length() && currentIndex == count) {
            return ret;
        } else {
            System.err.println("Warning: wrong number of element in split");
            return new String[0];
        }
    }

    // Attempts to parse a string specifying count ints in the format "1,2,3". If it cannot parse exactly that many
    // ints in that format, returns a zero-length array.
    private static int[] parseInts(String str, int count) {
        int[] ret = new int[count];
        
        String[] strings = split(str, ',', count);

        if (strings.length != count) {
            System.err.println("Warning: wrong number of ints in parseInts");
            return new int[0];
        }

        for (int i = 0; i < strings.length; i++) {
                if (!isAllDigits(strings[i])) {
                    System.err.println("Warning: non-digit character in string in parseInts");
                    return new int[0];
                }
                ret[i] = Integer.parseInt(strings[i]);
        }

        return ret;

    }

    /* a method setRow(int,String) that modifies one whole row of the array, given its position as an integer and
       the list of numbers as a String like “1,2,3”. The method must check that the index is valid and the numbers
       are correct (i.e. if the array has three columns, the String contains three numbers). If the index or the String
       is invalid, the method will do nothing. */
    public void setRow(int row, String stringValues) {
        if (row < getRows() ) {
            int[] intValues = parseInts(stringValues, getCols());
            if (intValues.length == getCols()) {
                for (int i = 0; i < intValues.length; i++) {
                    values[row][i] = intValues[i];
                }
            } else {
                System.err.println("Warning: problem parsing string in setRow");
            }
        } else {
            System.err.println("Warning: row specified is out of bounds in setRow");
        }
    }

    /* a method setColumn(int,String) that modifies one whole column of the array, given its position as an
       integer and the list of numbers as a String like “1,2,3”. The method must check that the index is valid and
       the numbers are correct (i.e. if the array has four rows, the String contains four numbers). If the index or the
       String is invalid, the method will do nothing. */
    public void setColumn(int col, String stringValues) {
        if (col < getCols() ) {
            int[] intValues = parseInts(stringValues, getRows());
            if (intValues.length == getRows()) {
                for (int i = 0; i < intValues.length; i++) {
                    values[i][col] = intValues[i];
                }
            } else {
                System.err.println("Warning: problem parsing string in setColumn");
            }
        } else {
            System.err.println("Warning: col specified is out of bounds in setColumn");
        }
    }

    // Converts a single row to a string, separated by commas
    private String rowToString(int row) {
        String ret = "";
        if (getCols() > 0) {
            ret += values[row][0];
            for (int i = 1; i < getCols(); i++) {
                ret += "," + values[row][i];
            }
        }

        return ret;
    }

    /* a method toString() that returns the values in the array as a String using square brackets, commas, and
       semicolons, e.g. “[1,2,3;4,5,6;3,2,1]”. */
    public String toString() {
        String ret = "[";
        if (getRows() > 0) {
            ret += rowToString(0);
            for (int i = 1; i < getRows(); i++) {
                ret += ";" + rowToString(i);
            }
        }

        return ret + "]";
    }

    /* A method prettyPrint() that prints the values of the matrix on screen in a legible format. Hint: you can use
       the special character ’\t’ (backslash-t) to mark a tabulator so that all numbers are placed in the same column
       regardless of their size. You can think of a tabulator character as a move-to-the-next-column command when
       printing on the screen. */
    public void prettyPrint() {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                System.out.print(values[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }


    /* Extend your Matrix class with a method setMatrix(String) that takes a String representing the numbers to be
       put in the elements of the array separated by commas, separating rows by semicolons, e.g. 1,2,3;4,5,6;7,8,9. */
    public void setMatrix(String matrix) {
        // Parse the string into a new array, so that we can be sure that the whole string is valid before
        // making any changes to the array. Otherwise, we might end up with a partially-updated array.
        int[][] newValues = new int[getRows()][getCols()];

        String[] rows = split(matrix, ';', getRows());
        if (rows.length != getRows()) {
            System.err.println("Warning: wrong number of rows in setMatrix");
            return;
        }

        for (int i = 0; i < rows.length; i++) {
            int[] row = parseInts(rows[i], getCols());
            if (row.length != getCols()) {
                System.err.println("Warning: wrong number of cols in setMatrix");
                return;
            }

            newValues[i] = row;
        }

        values = newValues;
    }

    /*
    Add some methods to your Matrix class from the other exercise to perform tests on the matrices you create
    using the methods from MatrixChecker. (Hint: these methods will need to create objects of type MatrixChecker).
    NB, I've made the methods on MatrixChecker static, so contra the hint I don't actually need to create an object.
    */

    public boolean isSymmetrical() {
        return MatrixChecker.isSymmetrical(values);
    }

    public boolean isTriangular() {
        return MatrixChecker.isTriangular(values);
    }
}