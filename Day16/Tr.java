import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Write a program that takes a name and two strings from the user at the
 * command line. If a file with that name exists, the program must show its
 * contents on screen, but substituting any occurrence of the first string by
 * the second string. If the file does not exist, the program must say so.
 */
 public class Tr {
     public static void main(String[] args) {
         if (args.length < 3) {
             System.out.println("Three arguments: filename fromString toString");
             return;
         }

         String fileName = args[0];
         String fromString = args[1];
         String toString = args[2];

         try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
             String line;
             while ((line = in.readLine()) != null) {
                 String changedLine = line.replace(fromString, toString);
                 System.out.println(changedLine);
             } 
             
         } catch (FileNotFoundException ex) {
             System.out.println("File " + fileName + " does not exist");
         } catch (IOException ex) {
             System.out.println("Error while reading file");
             ex.printStackTrace();
         }
     }
 }