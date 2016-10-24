/*
 * Implement the interface queue in a way that the next person retrieved is always a person over 65, 
 * if there is any in the queue; if not, it must be a person over 18, if there is any in the queue. Inside each age category, the behaviour
 * of the queue is typical FIFO: first in, first out.
 */

public class ClusteredQueue implements PersonQueue {
    private class PersonQueueNode {
        public Person p;
        public PersonQueueNode next;
    }

    PersonQueueNode first;


    /*
     * Inserts the Person p in the list in such a way that all Persons older than 65 are first, followed
     * by all Persons older than 18, followed by any 18 or under.
     */
    public void insert(Person p) {
        PersonQueueNode target;
        
        if (p.getAge() > 65) {
            target = findLastOlderThan(65);
        } else if (p.getAge() > 18) {
            target = findLastOlderThan(18);
        } else {
            target = findLast();
        }

        insertAfter(target, p);
    }

    /* 
     * Returns the first node that precedes a node containing a Person with the age less than or equal to
     * the specified age. If the list is maintained such that (e.g.) all Persons older than 65 are
     * stored before Persons 65 or younger, findLastOlderThan(65) will return the last element with
     * an age greater than 65.
     */
    private PersonQueueNode findLastOlderThan(int age) {
        if (first == null) {
            return null;
        }

        if (first.p.getAge() <= age) {
            return null;
        }

        PersonQueueNode current = first;
        while (current.next != null) {
            if (current.next.p.getAge() < age) {
                break;
            }
            current = current.next;
        }
        return current;
    }

    /*
     * Returns the last node in the list.
     */
    private PersonQueueNode findLast() {
        if (first == null) {
            return null;
        }

        PersonQueueNode current = first;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    /*
     * Insert the given person after the specified node. If location is null, insert the person at the
     * beginning of the list.
     */
    private void insertAfter(PersonQueueNode location, Person p) {
        PersonQueueNode newNode = new PersonQueueNode();
        newNode.p = p;

        if (first == null) {
            newNode.next = null;
            first = newNode;
            return;
        }

        if (location == null) {
            newNode.next = first;
            first = newNode;
            return;
        }

        newNode.next = location.next;
        location.next = newNode;
    }

    public Person retrieve() {
        if (first == null) {
            return null;
        }
        Person ret = first.p;
        first = first.next;

        return ret;
    }
}