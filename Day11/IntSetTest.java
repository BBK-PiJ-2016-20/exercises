public class IntSetTest {
    public static void main(String[] args) {
        IntSet s = new ListIntSet();
        
        s.toString();

        s.add(1);
        s.add(3);
        s.add(5);
        s.add(2);
        
        System.out.println("Should be true: " + s.contains(3));
        System.out.println("Should be false: " + s.contains(6));

        System.out.println("containsVerbose(1)");
        s.containsVerbose(1);

        System.out.println("\ncontainsVerbose(5)");
        s.containsVerbose(5);
        System.out.println("\ncontainsVerbose(9)");
        s.containsVerbose(9);
        
        System.out.println(s.toString());
    }
}