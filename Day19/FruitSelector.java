import java.util.ArrayList;
import java.util.List;

/**
 * Select apples that are green
 */
public class FruitSelector {

    public static List<Apple> getApplesByColour(List<Apple> apples, Colour colour) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : apples) {
            if (apple.getColour().equals(colour)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> getApplesOverWeight(List<Apple> apples, int limit) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : apples) {
            if (apple.getWeight() > limit) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> getApplesUnderWeight(List<Apple> apples, int limit) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : apples) {
            if (apple.getWeight() <= limit) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> getApplesIf(List<Apple> apples, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(10, Colour.RED));
        apples.add(new Apple(15, Colour.GREEN));
        apples.add(new Apple(10, Colour.YELLOW));
        apples.add(new Apple(200, Colour.BROWN));
        apples.add(new Apple(18, Colour.GREEN));
        apples.add(new Apple(150, Colour.RED));
        apples.add(new Apple(19, Colour.RED));

        List<Apple> greenApples = getApplesIf(apples, new AppleColourPredicate(Colour.GREEN));

        System.out.println("Number of green apples: " + greenApples.size());
        System.out.println(greenApples);

        List<Apple> redApples = getApplesIf(apples, new AppleColourPredicate(Colour.RED));

        System.out.println("Number of red apples: " + redApples.size());
        System.out.println(redApples);

        List<Apple> heavyApples = getApplesIf(apples, new AppleOverWeightPredicate(150));

        System.out.println("Number of heavy apples: " + heavyApples.size());
        System.out.println(heavyApples);

        List<Apple> lightApples = getApplesIf(apples, new AppleUnderWeightPredicate(150));

        System.out.println("Number of light apples: " + lightApples.size());
        System.out.println(lightApples);
    }

}

interface ApplePredicate {
    boolean test(Apple apple);
}

class AppleOverWeightPredicate implements ApplePredicate {
    private int limit;

    public AppleOverWeightPredicate(int limit) {
        this.limit = limit;
    }

    public boolean test(Apple apple) {
        return apple.getWeight() > limit;
    }
}

class AppleUnderWeightPredicate implements ApplePredicate {
    private int limit;

    public AppleUnderWeightPredicate(int limit) {
        this.limit = limit;
    }

    public boolean test(Apple apple) {
        return apple.getWeight() <= limit;
    }
}


class AppleColourPredicate implements ApplePredicate {
    private Colour colour;

    public AppleColourPredicate(Colour colour) {
        this.colour = colour;
    }

    public boolean test(Apple apple) {
        return apple.getColour().equals(colour);
    }
}