import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * How would you use streams to filter the first two meat dishes?
 */
 public class MeatFilter {
     public static void main(String[] args) {
         Dish[] dishes = {
             new Dish("Bolognese", false, 500, Dish.Type.MEAT),
             new Dish("Margherita", true, 300, Dish.Type.OTHER),
             new Dish("Bulgogi", false, 200, Dish.Type.MEAT),
             new Dish("Kimchi", true, 150, Dish.Type.OTHER),
             new Dish("Fish Pie", false, 500, Dish.Type.FISH),
             new Dish("Pulpo Gallego", false, 250, Dish.Type.FISH)
         };

         List<Dish> meatDishes = Arrays.stream(dishes).filter((dish) -> dish.getType() == Dish.Type.MEAT).limit(2).collect(Collectors.toList());

         System.out.println("First two meat dishes: " + meatDishes);
     }
 }