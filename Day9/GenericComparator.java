public class GenericComparator<T extends Comparable<T>> {
    public static void main(String[] args) {
        GenericComparator c = new GenericComparator();
        System.out.println(c.getMax("10", "2"));
    }

    public T getMax(T t, T u) {
        return (t.compareTo(u) > 0) ? t : u;
    }

    public String getMax(String s, String t) {
        int i = Integer.parseInt(s);
        int j = Integer.parseInt(t);
        return (new GenericComparator<Integer>()).getMax(i, j).toString();
    }
}