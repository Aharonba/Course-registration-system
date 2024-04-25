import java.util.ArrayList;

/**
 * Lecturer class that implements the FacultyMember interface.
 * This class is responsible for managing the lecturers.
 */
public class Lecturer extends User implements FacultyMember {
    private ArrayList<Course> lecturersCourses;

    public Lecturer(String name, int id, String username, String password, String department, String email, String phoneNum) {
        super(name, id, username, password, department, email, "Lecturer", phoneNum);
        this.lecturersCourses = new ArrayList<Course>();
    }


    // Method to add a course to the list of courses the lecturer is teaching.

    public void addCourse(Course course) {
        lecturersCourses.add(course);
    }

    public void removeCourse(Course course) {
        lecturersCourses.remove(course);
    }


}
