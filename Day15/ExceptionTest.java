import java.util.ArrayList;
import java.util.List;

/**
 * Read the following code and check whether there is anything wrong with it.
 * Then write some similar code and check your answer.

 * // Some code here 
 * try { 
 *      // more code here 
 *      list.add(newElement); 
 *      // more code
 * } catch (Exception ex) { 
 *      ex.printStackTrace(); 
 * } catch (NullPointerException ex) { 
 *      // This will never be reached, because a NullPointerException will be caught by Exception ex above, and the
 *      // compiler will complain.  
 *      ex.printStackTrace();
 * }
 */
public class ExceptionTest {
    public static void main(String[] args) {
        // Some code here
        List<Object> list = null;
        Object newElement = null;
        try {
            // more code here
            list.add(newElement);
            // more code
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException"); 
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Exception");
            ex.printStackTrace();
        } 
        

    }
}