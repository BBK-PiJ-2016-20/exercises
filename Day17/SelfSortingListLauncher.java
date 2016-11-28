import java.util.Random;

public class SelfSortingListLauncher {
    public static void main(String[] args) {
        SelfSortingList list = new SelfSortingList();
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            list.add(r.nextInt());
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.finish();
    }
}