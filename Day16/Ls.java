import java.io.File;

/**
 * Write a program that shows on screen the names of the files in the current
 * directory. (Hint: look at methods from class File).
 */
public class Ls {
    public static void main(String[] args) {
        File currentDirectory = new File(".");
        if (!currentDirectory.isDirectory()) {
            System.out.println("Not a directory");
            return;
        }

        File[] filesInDirectory = currentDirectory.listFiles();
        for (File file : filesInDirectory) {
            System.out.println(file.getName());
        }
    }
}