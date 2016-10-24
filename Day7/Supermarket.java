/* 
Create a class Supermarket that has two methods: addPerson(Person) and servePerson(). These
methods must call the appropriate methods of PersonQueue.
*/

class Supermarket {

    private PersonQueue q;

    public Supermarket() {
        q = new OldestQueue();
    }

    void addPerson(Person p) {
        q.insert(p);
    }

    /** Serves a person (by printing out their name), if there are any in the queue.
     * Returns true if a person was served, false otherwise.
     */
    public boolean servePerson() {
        Person p = q.retrieve();
        if (p != null) {
            System.out.println("Now serving: " + p.getName() + "(" + p.getAge() + ")");
            return true;
        } else {
            System.out.println("No-one to serve");
            return false;
        }
    }

    public static void main(String[] args) {
        Supermarket s = new Supermarket();

        s.addPerson(new Person("Alice", 25));
        s.addPerson(new Person("Bob", 26));
        s.addPerson(new Person("Clare", 24));
        s.addPerson(new Person("Daniel", 27));
        s.addPerson(new Person("Eleanor", 23));
        s.addPerson(new Person("Frank", 28));

        while (s.servePerson()) {
            // Do nothing            
        }

    }
}