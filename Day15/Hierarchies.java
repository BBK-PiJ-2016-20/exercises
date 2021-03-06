/**
 * Create a three-level hierarchy of exceptions (i.e. an exception extends some
 * exceptions that extends some exception). Now create a base-class A with a
 * method that throws an exception at the base of your hierarchy. Inherit B from
 * A and override the method so it throws an exception at level two of your
 * hierarchy. Repeat by inheriting class C from B. In the launch() method of
 * another class, create a C and upcast it to A, then call the method.
 */
public class Hierarchies {
    public void launch() throws BaseException {
        A a = new C();
        a.throwIt();
    }

    public static void main(String args[]) {
        Hierarchies launcher = new Hierarchies();
        try {
            launcher.launch();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}