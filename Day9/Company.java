public class Company {
    DoublyLinkedList<String> names;
    DoublyLinkedList<String> nationalInsuranceNumbers;

    public Company() {
        names = new DoublyLinkedList<String>();
        nationalInsuranceNumbers = new DoublyLinkedList<String>();
    }

    public void addEmployee(String name, String nationalInsuranceNumber) {
        names.add(name);
        nationalInsuranceNumbers.add(nationalInsuranceNumber);
    }

    public void printEmployees() {
        String currentName = names.next();
        String currentNI = nationalInsuranceNumbers.next();

        while (currentName != null && currentNI != null) {
            System.out.println(currentName + ": " + currentNI);
            currentName = names.next();
            currentNI = nationalInsuranceNumbers.next();
        }
    }
}