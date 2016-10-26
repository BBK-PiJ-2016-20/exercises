public class Teacher {
    private String name;
    
    /**
     * Create a Teacher with the supplied name.
     */
    public Teacher(String name) {
        this.name = name;
    }
    
    /**
     * Access the Teacher's name
     *
     * @returns the teacher's name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Teach a lesson.
     *
     * @param   lessonName    the name of the lesson to teach.
     */
    public void teach(String lessonName) {
        System.out.println("Teaching lesson: " + lessonName);
    }
}