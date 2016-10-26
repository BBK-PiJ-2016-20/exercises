/**
* A lecturer has both teaching and research responsibilities
*/
public class Lecturer extends Teacher {

    public Lecturer(String name) {
        super(name);
    }

    /** 
     * Do research.
     *
     * @param   topic   the topic to research.
     */
    public void doResearch(String topic) {
        System.out.println("Doing research on: " + topic);
    }
}
