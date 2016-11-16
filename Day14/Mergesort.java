import java.util.ArrayList;
import java.util.List;

public class Mergesort {

    private static <T extends Comparable<T>> List<T> merge(List<T> first, List<T> second) {
        int firstIdx = 0;
        int secondIdx = 0;
        List<T> result = new ArrayList<T>();

        while (firstIdx < first.size() && secondIdx < second.size()) {
            T firstElem = first.get(firstIdx);
            T secondElem = second.get(secondIdx);
            if (firstElem.compareTo(secondElem) < 0) {
                result.add(firstElem);
                firstIdx++;
            } else {
                result.add(secondElem);
                secondIdx++;
            }
        }

        result.addAll(first.subList(firstIdx, first.size()));
        result.addAll(second.subList(secondIdx, second.size()));

        return result;
    }

    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
        int size = list.size();
        if (size <= 1) {
            return list;
        }
        List<T> left = sort(list.subList(0, size / 2));
        List<T> right = sort(list.subList(size / 2, size));
        return merge(left, right);
    }
}