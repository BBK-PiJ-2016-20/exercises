/**
 * Write a program that reads 10 numbers from the user and then prints the mean
 * average. If the user inputs something that is not a number, the program
 * should complain and ask for a number again until 10 numbers have been
 * introduced.
 *
 * Modify the program so that it first asks how many numbers the user wants to
 * enter, and then asks for the numbers. The computer should complain if the
 * user enters something that is not a number in both cases. Use methods to
 * prevent code repetitions.
 */
public class UserInput {

    public static double readNumber(String prompt) {
        double number = 0;
        boolean isNumber = false;

        while (!isNumber) {
            System.out.print(prompt);
            String input = System.console().readLine();

            try {
                number = Double.parseDouble(input);
            } catch (NumberFormatException ex) {
                System.out.println(input + " is not a number, please try again");
                continue;
            }
            
            isNumber = true;
        }

        return number;
    }

    public static void main(String[] args) {
        double average = 0;
        int entered = 0;

        int toEnter = (int) readNumber("How many numbers? ");

        while (entered < toEnter) {
            double number = readNumber("Number " + (entered + 1) + " of " + toEnter + ": ");
            entered++;
            average = ((average * (entered - 1)) + number) / entered;
        }

        System.out.println("Average is: " + average);
    }
}