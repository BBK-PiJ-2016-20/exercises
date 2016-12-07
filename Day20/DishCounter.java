import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * How would you count the number of dishes in a stream using the map and reduce
 * methods?
 */
 public class DishCounter {
     public static void main(String[] args) {
         Dish[] dishes = {
             new Dish("Bolognese", false, 500, Dish.Type.MEAT),
             new Dish("Margherita", true, 300, Dish.Type.OTHER),
             new Dish("Bulgogi", false, 200, Dish.Type.MEAT),
             new Dish("Kimchi", true, 150, Dish.Type.OTHER),
             new Dish("Fish Pie", false, 500, Dish.Type.FISH),
             new Dish("Pulpo Gallego", false, 250, Dish.Type.FISH)
         };

         int numberOfDishes = Arrays.stream(dishes)
                                    .map(dish -> 1)
                                    .reduce(0, (x, y) -> x + y);

         System.out.println("Number of dishes: " + numberOfDishes);
     }
 }