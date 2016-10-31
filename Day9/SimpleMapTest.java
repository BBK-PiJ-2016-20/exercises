public class SimpleMapTest {
    public static void main(String[] args) {
        SimpleMap<String, String> map = new SimpleMap<String, String>();

        map.put("Name", "Tim");
        map.put("Age", "35");

        System.out.println(map.get("Name"));
        System.out.println(map.get("Age"));
    }
}