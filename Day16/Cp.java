import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Write a program that takes two names from the user at the command line. If a
 * file with the first name exists, the program must copy it into a file with
 * the second name. If the first file does not exist, the program must say so.
 * If the second file does exists, the program must ask the user whether to
 * overwrite it or not, and act accordingly.
 */
public class Cp {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("You must give me two filenames");
            return;
        }

        String fromName = args[0];
        String toName = args[1];

        File fromFile = new File(fromName);        
        if (!fromFile.exists()) {
            System.out.println(fromFile + " does not exist. Stopping here.");
            return;
        }

        File toFile = new File(toName);
        if (toFile.exists()) {
            System.out.println(toName + " already exists. Should we overwrite it (y/n)?");
            String answer = System.console().readLine();
            if (!answer.startsWith("y")) {
                System.out.println("Not overwriting. Stopping here.");
                return;
            }
        }

        try (BufferedReader in = new BufferedReader(new FileReader(fromFile));
             FileWriter out = new FileWriter(toFile)) {
            String line = in.readLine();
            while (line != null) {
                // readLine() strips \n at the end of lines, so add it back here.
                // This may add an extra line break to the last line if the last line
                // did not have a line break in the original file.
                out.write(line + "\n");
                line = in.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error copying file");
            ex.printStackTrace();
        }
    }
}