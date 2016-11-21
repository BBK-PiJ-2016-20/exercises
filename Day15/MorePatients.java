import java.util.ArrayList;
import java.util.List;

/**
 * Write a class that asks for data (name and year of birth) about new patients
 * in a hospital and keeps them in a list of Patient. The constructor of Patient
 * must throw an IllegalArgumentException if the age of the patient is negative
 * or greater than 130.
 */
public class MorePatients {
    private List<Patient> patients;

    public MorePatients() {
        patients = new ArrayList<>();
    }

    public static int readInt(String prompt) {
        int number = 0;
        boolean isNumber = false;

        while (!isNumber) {
            System.out.print(prompt);
            String input = System.console().readLine();

            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println(input + " is not an integer, please try again");
                continue;
            }
            
            isNumber = true;
        }

        return number;
    }

    /**
     * Add a new patient, reading information from the console. Refuses to add a
     * patient, and asks the user to re-enter, if the information supplied is
     * invalid.
     */
    public void newPatient() {
        System.out.print("Name: ");

        String name = System.console().readLine();

        int birthYear = 0;
        Patient newPatient = null;

        while (newPatient == null) {
            birthYear = readInt("Birth year: ");

            try {
                newPatient = new Patient(name, birthYear);
            } catch (IllegalArgumentException ex) {
                System.out.println(birthYear + " is not a reasonable birth year. Please try again");
                continue;
            }
        }

        patients.add(newPatient);
    }

    public static void main(String[] args) {
        int toEnter = readInt("How many patients to enter? ");
        int entered = 0;
        MorePatients patients = new MorePatients();

        while (entered < toEnter) {
            System.out.println("Patient " + (entered + 1) + " of " + toEnter);
            patients.newPatient();
            entered++;
        }
    }
}