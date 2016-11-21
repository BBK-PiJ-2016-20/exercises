/**
 * Create two exceptions, one checked exception and one runtime exception. Then
 * create a simple class that will throw each of them in two different
 * situations, according to user input:
 *
 * 1. inside a try block. 2. outside a try block.
 *
 * Note: Two exceptions times two situations means four different inputs from
 * users. Create the new exceptions with four different messages (using the
 * appropriate constructor), e.g. "I am a checked exception and I have been
 * thown out of a try block".
 *
 * Assuming you do all of the above inside the launch() method of your class,
 * did you have to make any changes to the method’s declaration?
 */
public class FirstExceptions {
    public static class CheckedException extends Exception {
        public CheckedException(boolean inTry) {
            super("I am a checked exception thrown " + (inTry ? "in" : "out of") + " a try block");
        }
    }

    public static class UncheckedException extends RuntimeException {
        public UncheckedException(boolean inTry) {
            super("I am a runtime exception thrown " + (inTry ? "in" : "out of") + " a try block");
        }
    }

    public void launch(int input) throws CheckedException {
        switch (input) {
            case 1:
                throw new CheckedException(false);
            case 2:
                try {
                    throw new CheckedException(true);
                } catch (CheckedException ex) {
                    System.out.println("Exception: " + ex.getMessage());
                }
                break;
            case 3:
                throw new UncheckedException(false);
            case 4:
                try {
                    throw new UncheckedException(true);
                } catch(UncheckedException ex) {
                    System.out.println("Exception: " + ex.getMessage());
                }
                break;            
        }
    }

    public static void main(String[] args) {
        System.out.println("1. Check exception out of a try block");
        System.out.println("2. Check exception in a try block");
        System.out.println("3. Unchecked exception out of a try block");
        System.out.println("4. Unchecked exception in a try block");
        System.out.print("Choose: ");

        try {
            int choice = Integer.parseInt(System.console().readLine());

            FirstExceptions launcher = new FirstExceptions();
            launcher.launch(choice);
        } catch (Exception ex) {
            System.out.println("Top-level exception: " + ex.getMessage());
        }        
    }

}