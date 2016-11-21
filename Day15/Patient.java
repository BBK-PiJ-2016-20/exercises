import java.util.Calendar;

/**
 * A class to represent a patient's name and birth year, which ensures that the
 * birth year is reasonable, i.e. which gives 0 <= age <= 130
 */
public class Patient {
    private String name;
    private int birthYear;

    public Patient(String name, int birthYear) {
        this.name = name;

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int age = currentYear - birthYear;
        if (age < 0) {
            throw new IllegalArgumentException(birthYear + " gives an age < 0");
        } else if (age > 130) {
            throw new IllegalArgumentException(birthYear + " gives an age > 130");
        }
        this.birthYear = birthYear;
    }
}