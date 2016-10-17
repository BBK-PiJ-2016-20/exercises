public class Main {
    public static void main(String[] args) {
        Matrix m = new Matrix(4, 4);
        m.setElement(1, 1, 2);
        m.setElement(10, 10, 2); // Should warn that row / col are out of bounds

        m.setRow(0, "1,2,3,4"); 
        m.setRow(10, "1,2"); // Should warn that row is out of bounds
        m.setRow(0, "1,2,3"); // Should warn about wrong number of elements
        m.setRow(0, "1 , 2 , 3"); // Should warn about non-digit characters

        m.setColumn(0, "1,2,3,4"); 
        m.setColumn(10, "1,2"); // Should warn that col is out of bounds
        m.setColumn(0, "1,2,3"); // Should warn about wrong number of elements
        m.setColumn(0, "1 , 2 , 3"); // Should warn about non-digit characters

        System.out.println(m.toString()); // Should print [1,2,3,4;2,2,1,1;3,1,1,1;4,1,1,1]
        m.prettyPrint();

        m.setMatrix("1,2,3,4;5,6,7,8;9,10,11,12;13,14,15,16");
        m.prettyPrint();

        int[] ints = {1, 2, 3, 2, 1};
        System.out.println("Is symmetrical: " + MatrixChecker.isSymmetrical(ints)); // Should print Is symmetrical: true
        int[] ints2 = {1, 2, 3, 3, 1};
        System.out.println("Is symmetrical: " + MatrixChecker.isSymmetrical(ints2)); // Should print Is symmetrical: false

        int[][] intMatrix = { {1, 2}, {2, 1}};
        System.out.println("Is symmetrical: " + MatrixChecker.isSymmetrical(intMatrix)); // Should print Is symmetrical: true
        int[][] intMatrix2 = { {1, 2}, {1, 2}};
        System.out.println("Is symmetrical: " + MatrixChecker.isSymmetrical(intMatrix2)); // Should print Is symmetrical: false
        
        int[][] triangular = { {1, 2, 3}, {0, 1, 2}, {0, 0, 1}};
        System.out.println("Is triangular: " + MatrixChecker.isTriangular(triangular)); // Should print Is triangular: true
        int[][] notTriangular = { {1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        System.out.println("Is triangular: " + MatrixChecker.isTriangular(notTriangular)); // Should print Is triangular: false

        Matrix symmetricalMatrix = new Matrix(2, 2);
        symmetricalMatrix.setMatrix("1,2;2,1");
        System.out.println("Is symmetrical: " + symmetricalMatrix.isSymmetrical()); // Should print Is symmetrical: true
        Matrix notSymmetricalMatrix = new Matrix(2, 2);
        notSymmetricalMatrix.setMatrix("1,2;1,2");
        System.out.println("Is symmetrical: " + notSymmetricalMatrix.isSymmetrical()); // Should print Is symmetrical: false

        Matrix triangularMatrix = new Matrix(3, 3);
        triangularMatrix.setMatrix("1,2,3;0,1,2;0,0,1");
        System.out.println("Is triangular: " + triangularMatrix.isTriangular()); // Should print Is triangular: true
        Matrix notTriangularMatrix = new Matrix(3, 3);
        notTriangularMatrix.setMatrix("1,2,3;1,2,3;1,2,3");
        System.out.println("Is triangular: " + notTriangularMatrix.isTriangular()); // Should print Is triangular: false
        
        
        
        
        
    }
}