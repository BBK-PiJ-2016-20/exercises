public class SortedListTest {
    public static void main(String[] args) {
        SortedList<Integer> l = new SortedList<Integer>();
        l.add(10);
        l.add(20);
        l.add(15);
        l.add(17);

        Integer i = l.next();
        while (i != null) {
            System.out.println(i);
            i = l.next();
        }
    }
}