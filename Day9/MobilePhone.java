public class MobilePhone extends OldPhone {

    public MobilePhone(String brand) {
        super(brand);

        savedNumbers = new String[MAX_SAVED_NUMBERS];
        for (int i = 0; i < MAX_SAVED_NUMBERS; i++) {
            savedNumbers[i] = null;
        }
    }

    /**
     * Rings an alarm (by printing the supplied message)
     *
     * @param message the message to print out when the alarm "rings"
     */
    public void ringAlarm(String message) {
        System.out.println("Alarm: " + message);
    }

    /**
     * Plays a game (by printing out the name of the game)
     *
     * @param game the name of the game to "play"
     */
    private void playGame(String game) {
        System.out.println("Playing: " + game);
    }

    private String[] savedNumbers;
    private static final int MAX_SAVED_NUMBERS = 10;

    /**
     * Store the number in the recently called list (removing the oldest number if necessary)
     *
     * @param number the new number to add.
     */
    protected void storeNumber(String number) {
        // Move the saved numbers one space down in the array to free up space in the first element
        // of the array to store the new number. This moves numbers every time a new number is added,
        // which is obviously inefficient, but easy to write.
        for (int i = MAX_SAVED_NUMBERS - 1; i > 0; i--) {
            savedNumbers[i] = savedNumbers[i-1];
        }
        savedNumbers[0] = number;
    }

    @Override
    public void call(String number) {
        storeNumber(number);
        super.call(number);
    }

    /**
     * Print out the last MAX_SAVED_NUMBERS numbers called.
     */
    public void printLastNumbers() {
        System.out.println("Numbers called:");
        for (int i = 0; i < MAX_SAVED_NUMBERS; i++) {
            if (savedNumbers[i] != null) {
                System.out.println(savedNumbers[i]);
            }
        }
        System.out.println("End of numbers called");
    }
}