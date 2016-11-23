import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Write a program that takes a name from the user at the command line. If a file
 * with that name exists, the program must show its contents on screen. If it
 * does not, the program must say so.
 *
 */
public class Cat {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("You must give me one file name.");
            return;
        }

        String fileName = args[0];

        File file = new File(fileName);

        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                System.out.println(line);
                line = in.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Error while reading file");
            ex.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                System.out.println("Error closing file");
            }
        }
    }
}