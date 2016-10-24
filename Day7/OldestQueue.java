/**
Implement the interface queue in a way that the person at the end (i.e. the person that is retrieved next time the
method retrieve() is called) is always the oldest person.
*/

public class OldestQueue implements PersonQueue {
    private static class PersonQueueNode {
        Person p;
        PersonQueueNode next;
    }

    private PersonQueueNode first = null;
    
    /* Inserts the Person object so that it is in front of all current members that are younger
     * than it. This means that when the first person is removed from the queue, they will be
     * the oldest.
     */
    public void insert(Person p) {
        PersonQueueNode newNode = new PersonQueueNode();
        newNode.p = p;

        // The queue is empty
        if (first == null) {
            newNode.next = null;
            first = newNode;
            return;
        } 

        // The new Person is older than the first Person, so we need to update first
        if (first.p.getAge() < p.getAge()) {
            newNode.next = first;
            first = newNode;
            return;
        }

        // We need to search through the remaining Persons in the queue to find the right place to insert
        PersonQueueNode current = first;
        while (current.next != null) {
            if (current.next.p.getAge() < p.getAge()) {
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        }

        // We reached the end of the list without finding a younger Person, so insert the new Person at the end.
        newNode.next = null;
        current.next = newNode;
    }

    /*
     * insert ensures that the oldest Person is always first in the queue, so retrieve can simply retrieve
     * the first Person
     */
    public Person retrieve() {
        if (first == null) {
            return null;
        }
        Person ret = first.p;
        first = first.next;
        return ret;
    }

}