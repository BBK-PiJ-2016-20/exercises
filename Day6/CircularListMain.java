public class CircularListMain {
    public static void main(String[] args) {
        CircularPatientList list = new CircularPatientList();

        System.out.println("No patients");
        list.printPatients();

        list.add(new Patient("Alice", 10, "Broken leg"));
        list.add(new Patient("Bob", 34, "Broken arm"));
        list.add(new Patient("Claire", 34, "Stomach ache"));
        list.add(new Patient("Daniel", 25, "Headache"));

        System.out.println("Four patients");
        list.printPatients();

        list.deleteByName("Alice");
        list.deleteByName("Daniel");

        System.out.println("Deleted two patients");
        list.printPatients();

        list.add(new Patient("Eleanor", 50, "Nose bleed"));
        list.deleteByName("Frank");

        System.out.println("Added another patient");
        list.printPatients();

    }
}