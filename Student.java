import java.util.ArrayList;

/**
 * Student class that extends the User class and implements the CourseObserver interface.
 * This class is responsible for managing the students.
 */
public class Student extends User implements CourseObserver {
    private ArrayList<Course> studentsCourses;

    private ArrayList<String> notifications;

    public Student(String name, int id, String username, String password, String department, String email, String phoneNum) {
        super(name, id, username, password, department, email, "Student", phoneNum);
        this.studentsCourses = new ArrayList<Course>();
        this.notifications = new ArrayList<String>();
    }

    public void addCourse(Course course) {
        studentsCourses.add(course);
    }

    public void removeCourse(Course course) {
        studentsCourses.remove(course);
    }

    public void update(String notification) {
        notifications.add(notification);
    }


}
