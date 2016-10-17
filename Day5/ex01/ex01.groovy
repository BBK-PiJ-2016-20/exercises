print("Enter a number: ");
int x = Integer.parseInt(System.console().readLine());

print("Enter another number: ");
int y = Integer.parseInt(System.console().readLine());

boolean entered = false;
while (!entered) {
    println("Choose an operation:")
    println("1. Add");
    println("2. Subtract");
    println("3. Multiply");
    println("4. Divide");
    println("5. Modulus");
    print("? ");

    int operation = Integer.parseInt(System.console().readLine());

    entered = true;

    switch (operation) {
        case 1:
            Calculator.add(x, y);
            break;
        case 2:
            Calculator.subtract(x, y);
            break;
        case 3:
            Calculator.multiply(x, y);
            break;
        case 4:
            Calculator.divide(x, y);
            break;
        case 5:
            Calculator.modulus(x, y);
            break;
        default:
            println("That is not a valid option. Try again");
            entered = false;
    }
}