import java.util.ArrayList;
import java.util.Scanner;


/**
 * Course class that implements the Subject interface.
 * This class is responsible for managing the courses.
 */


public class Course implements Subject {
    private final String courseName;
    private final Integer courseNumber;
    private final String courseType;
    private int availableSeats;
    private int totalSeats;
    private ArrayList<CourseObserver> observers;
    Scanner scanner = new Scanner(System.in);


    public Course(String courseType, String courseName, Integer courseNumber, int totalSeats) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.availableSeats = totalSeats;
        this.totalSeats = totalSeats;
        this.courseType = courseType;
        observers = new ArrayList<CourseObserver>();
    }

    public void printCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Number: " + courseNumber);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Course Type: " + courseType + "\n");
    }

    public String getCourseName() {
        return courseName;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public String getCourseType() {
        return courseType;
    }


    public int getCourseNumber() {
        return courseNumber;
    }

    /**
     * Method to enroll a student in a course.
     * If there are available seats, the student is added to the course.
     * If there are no available seats, the student is asked if they would like to be notified if a place becomes available.
     * If the student chooses to be notified, they are added to the list of observers.
     * If the student chooses not to be notified, they are not added to the list of observers.
     */

    public void enterCourse(Student student) {
        if (availableSeats > 0) {
            availableSeats--;
            student.addCourse(this);
            System.out.println(student.getName() + " managed to enroll in the course\n");
            notifyObservers();
        } else {
            System.out.println("No available seats.");
            System.out.println("Would you like to be notified if a place becomes available in the course? If so press Y otherwise press N.");
            String response = scanner.nextLine();
            if (response.equals("Y")) {
                addObserver(student);
                System.out.println("You will be notified if a place becomes available in the course.\n");
            } else {
                System.out.println("You will not be notified if a place becomes available in the course.\n");
            }


        }
    }

    /**
     * Method to remove a student from a course.
     * The student is removed from the course and the number of available seats is incremented.
     */

    public void exitCourse(Student student) {
        availableSeats++;
        student.removeCourse(this);
        System.out.println(student.getName() + " managed to cancel the registration for the course.\n");
    }


    /**
     * Methods responsible for implementing the observer pattern
     */
    public void addObserver(CourseObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(CourseObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (CourseObserver observer : observers) observer.update("Course " + courseName + " has available seats.");
    }


}

