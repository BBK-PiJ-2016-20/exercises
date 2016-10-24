public class CircularPatientList {

    private static class CircularPatientNode {
        public Patient patient;
        public CircularPatientNode next;
    }

    private CircularPatientNode first;

    public void add(Patient p) {
        CircularPatientNode last = findLast();
        CircularPatientNode newNode = new CircularPatientNode();
        newNode.patient = p;

        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }

        newNode.next = first;
    }

    public void printPatients() {
        if (first == null) {
            return;
        }
        CircularPatientNode current = first;
        while (current.next != first) {
            current.patient.print();
            current = current.next;
        }
        current.patient.print();
    }

    public void deleteByName(String name) {
        if (first == null) {
            return;
        }
        if (first.patient.getName() == name) {
            CircularPatientNode last = findLast();
            if (last == first) {
                first = null;
            } else {
                last.next = first.next;
                first = first.next;
            }
            return;
        }
        CircularPatientNode current = first;
        while (current.next != first) {
            if (current.next.patient.getName() == name) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }

    private CircularPatientNode findLast() {
        if (first == null) {
            return null;
        }
        CircularPatientNode current = first;
        while (current.next != first) {
            current = current.next;
        }
        return current;
    }
}