public class HashTableTest {

    public static void printList(DoublyLinkedList<String> list) {
        String s = list.next();
        while (s != null) {
            System.out.println(s);
            s = list.next();
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