import java.util.Iterator;

public class HashTableTest {

    public static void printList(Iterator<String> list) {
        while (list.hasNext()) {
            String s = list.next();
            System.out.println(s);
        } 
    }

    public static void main(String[] args) {
        HashTable<String, String> map = new HashTable<String, String>();

        map.put("Name", "Tim");
        map.put("Name", "Fisken");
        map.put("Age", "35");

        printList(map.get("Name"));
        printList(map.get("Age"));
    }
}