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

    }
}