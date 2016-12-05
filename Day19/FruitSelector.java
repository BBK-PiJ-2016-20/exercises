import java.util.ArrayList;
import java.util.List;

/**
 * Select apples that are green
 */
public class FruitSelector {

    public static List<Apple> getGreenApples(List<Apple> apples) {
        List<Apple> greenApples = new ArrayList<>();

        for (Apple apple : apples) {
            if (apple.getColour().equals(Colour.GREEN)) {
                greenApples.add(apple);
            }
        }

        return greenApples;
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(10, Colour.RED));
        apples.add(new Apple(15, Colour.GREEN));
        apples.add(new Apple(10, Colour.YELLOW));
        apples.add(new Apple(13, Colour.BROWN));
        apples.add(new Apple(18, Colour.GREEN));
        apples.add(new Apple(12, Colour.RED));
        apples.add(new Apple(19, Colour.RED));

        List<Apple> greenApples = getGreenApples(apples);

        System.out.println("Number of green apples: " + greenApples.size());
    }
}