/**
 * Write a program that reads 10 numbers from the user and then prints the mean
 * average. If the user inputs something that is not a number, the program
 * should complain and ask for a number again until 10 numbers have been
 * introduced.
 */
public class UserInput {
    public static void main(String[] args) {
        double average = 0;
        int entered = 0;

        System.out.println("Enter 10 numbers");
        while (entered < 10) {
            System.out.print("A number: ");
            String input = System.console().readLine();
            double number;

            try {
                number = Double.parseDouble(input);
            } catch (NumberFormatException ex) {
                System.out.println(input + " is not a number, please try again");
                continue;
            }

            entered++;
            average = ((average * (entered - 1)) + number) / entered;
        }

        System.out.println("Average is: " + average);
    }
}