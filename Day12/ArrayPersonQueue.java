/*
 * An implementation of PersonQueue using an array for storage.
 */
 
class ArrayPersonQueue implements PersonQueue {
    private Person[] people;
    private int capacity;
    private int size;
    private int first;

    private static int INITIAL_CAPACITY = 5;

    public ArrayPersonQueue() {
        capacity = INITIAL_CAPACITY;
        people = new Person[capacity];
        size = 0;
        first = 0;
    }

    /** 
    * Add a Person to the queue. This is implemented by adding a Person to the end of the
    * people array, growing the array if necessary.
    */
    public void insert(Person p) {
        if (capacity == size) {
            grow();
        }
        people[size] = p;
        size++;
    }

    /**
    * Grows the internal people array, creating a new array twice the size of the old one
    * copying the contents of the old array into the new one.
    */
    private void grow() {
        Person[] oldPeople = people;
        capacity *= 2;
        people = new Person[capacity];
        for (int i = first; i < size; i++) {
            people[i] = oldPeople[i];
        }
    }

    public void dump() {
        System.out.println("capacity: " + capacity);
        System.out.println("size: " + size);
        System.out.println("first: " + first);
    }

    /** 
     * Retrieve the Person at the beginning of the queue, removing it from the queue.
     * If there is enough space at the beginning of the array to hold all elements of
     * the queue, move the elements into that space. The idea here is to limit the
     * number of times that the array needs to be grown.
     */
    public Person retrieve() {
        if (first == size) {
            return null;
        }
        Person ret = people[first];
        people[first] = null;
        first++;
        if (first > (size - first)) {
            for (int i = 0; i < (size - first); i++) {
                people[i] = people[first + i];
            }
            size = size - first;
            first = 0;
        }
        return ret;
    }
}