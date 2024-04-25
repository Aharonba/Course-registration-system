import java.util.HashMap;
import java.util.Map;


/**
 * CourseFactory class implements the factory design pattern and flyweight pattern.
 * 1. The factory design pattern is used to create different types of courses (Seminar, Mandatory, Elective).
 * 2. The flyweight pattern is used to store the created courses in a map to avoid creating duplicate courses.
 */
public class CourseFactory {
    private static Map<Integer, Course> courseMap;

    public CourseFactory() {
        courseMap = new HashMap<>();
    }

    public static Course getCourse(String courseType, String courseName, Integer courseNumber, int totalSeats) {
        if (!(courseType.equals("Seminar")) && (!courseType.equals("Mandatory")) && (!courseType.equals("Elective"))) {
            System.out.println("Invalid course type. please enter Seminar, Mandatory or Elective.");
            return null;

        } else if (courseMap.containsKey(courseNumber)) {
            System.out.println("Course with course number " + courseNumber + " already exists.");
            return courseMap.get(courseNumber);
        } else {
            Course course = null;
            //create course by factory design pattern
            switch (courseType) {
                case "Seminar" -> course = new SeminarCourse(courseType, courseName, courseNumber, totalSeats);
                case "Mandatory" -> course = new MandatoryCourse(courseType, courseName, courseNumber, totalSeats);
                case "Elective" -> course = new ElectiveCourse(courseType, courseName, courseNumber, totalSeats);
            }

            courseMap.put(courseNumber, course);
            return course;
        }
    }
}

