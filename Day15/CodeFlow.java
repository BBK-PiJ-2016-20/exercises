import java.util.ArrayList;
import java.util.List;

/**
 * Look at the following code and write the code flow (use the line numbers to
 * indicate which lines are executed in which order) in the following
 * situations: 
 
 * userInput is 0. 
 * userInput is 2. 
 * userInput is 4. 
 * userInput is 6.
*/
public class CodeFlow {
    public static void launch(int userInput) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);
        try {
            intList.remove(0);
            System.out.println("Line 11: " + intList.get(userInput));
            intList.remove(0);
            System.out.println("Line 13: " + intList.get(userInput));
            intList.remove(0);
            System.out.println("Line 15: " + intList.get(userInput));
            intList.remove(0);
            System.out.println("Line 17: " + intList.get(userInput));
            intList.remove(0);
            System.out.println("Line 19: " + intList.get(userInput));
            intList.remove(0);
            System.out.println("Line 21: " + intList.get(userInput));
            intList.remove(0);
            System.out.println("Line 23: " + intList.get(userInput));
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }        
    }

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Specify an argument");
            return;
        }
        int input = Integer.parseInt(args[0]);
        CodeFlow launcher = new CodeFlow();
        launcher.launch(input);
    }
}
