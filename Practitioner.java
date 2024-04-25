import java.util.ArrayList;

/**
 * Practitioner class that implements the FacultyMember interface.
 * This class is responsible for managing the practitioners.
 */
public class Practitioner extends User implements FacultyMember {
    private ArrayList<Course> practitionersCourses;

    public Practitioner(String name, int id, String username, String password, String department, String email, String phoneNum) {
        super(name, id, username, password, department, email, "Practitioner", phoneNum);
        this.practitionersCourses = new ArrayList<Course>();
    }

    // Method to add a course to the list of courses the practitioner is teaching.

    public void addCourse(Course course) {
        practitionersCourses.add(course);
    }

    public void removeCourse(Course course) {
        practitionersCourses.remove(course);
    }


}
