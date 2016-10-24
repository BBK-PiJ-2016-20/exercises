/* A simple main method for testing a PersonQueue implementation */
class PersonQueueMain {
    public static void main(String[] args) {
        PersonQueue q = new ArrayPersonQueue();
        q.insert(new Person("Alice", 25));
        q.insert(new Person("Bob", 25));
        q.insert(new Person("Clare", 25));
        q.insert(new Person("Daniel", 25));
        q.insert(new Person("Eleanor", 25));
        q.insert(new Person("Frank", 25));

        Person p = q.retrieve();
        while (p != null) {
            p.print();
            p = q.retrieve();
        }

    }
}