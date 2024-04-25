import java.util.ArrayList;

/**
 * RegistrationSystem class that implements the Singleton design pattern.
 * This class is responsible for managing the registration system.
 * this class implements the factory design pattern.
 */

public class RegistrationSystem {
    private static RegistrationSystem instance = new RegistrationSystem();
    private ArrayList<Course> courses;
    private ArrayList<User> registered_users;
    private ArrayList<User> users_logged_in;
    private CourseFactory courseFactory;


    private RegistrationSystem() {
        this.courses = new ArrayList<>();
        this.registered_users = new ArrayList<>();
        this.users_logged_in = new ArrayList<>();
        this.courseFactory = new CourseFactory();
    }

    public static RegistrationSystem getInstance() {
        return instance;
    }

    /**
     * Method to sign up a user.
     * If the username or password is already taken, the user is not signed up.
     * If the user type is invalid, the user is not signed up.
     * If the user is signed up successfully, they are added to the list of registered users.
     * If the number of users logged in is less than 100, the user is added to the list of users logged in.
     */

    public User sign_up(String name, int id, String username, String password, String department, String email, String type, String phoneNum) {
        {
            for (User user : registered_users) {
                if (user.getUsername().equals(username)) {
                    System.out.println("Username already taken.");
                    return null;
                }
                if (user.getPassword().equals(password)) {
                    System.out.println("Password already taken.");
                    return null;
                }
            }
            User user;
            switch (type) {
                case "Student" -> {
                    user = new Student(name, id, username, password, department, email, phoneNum);
                    registered_users.add(user);
                    if (users_logged_in.size() < 100) {
                        users_logged_in.add(user);
                    }
                    System.out.println(user.getName() + " has signed up.\n");
                    return user;
                }
                case "Lecturer" -> {
                    user = new Lecturer(name, id, username, password, department, email, phoneNum);
                    registered_users.add(user);
                    if (users_logged_in.size() < 100) {
                        users_logged_in.add(user);
                    }
                    System.out.println(user.getName() + " has signed up.\n");
                    return user;
                }
                case "Practitioner" -> {
                    user = new Practitioner(name, id, username, password, department, email, phoneNum);
                    registered_users.add(user);
                    if (users_logged_in.size() < 100) {
                        users_logged_in.add(user);
                    }
                    System.out.println(user.getName() + " has signed up.\n");
                    return user;
                }
                default -> {
                    System.out.println("Invalid user type.\n");
                    return null;
                }
            }


        }


    }

    /**
     * Method to sign in a user.
     * The method checks if the username and password are correct.
     * If the user is not registered, they are not signed in.
     * If the number of users logged in is up or equal to 100, the user is not signed in.
     */
    public void sign_in(String username, String password) {

        if (users_logged_in.size() < 100) {
            for (User user : registered_users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    users_logged_in.add(user);
                    System.out.println("User " + user.getName() + " has logged in.");
                    return;
                }

            }
            System.out.println("Invalid username or password.");

        } else {
            System.out.println("Maximum number of users logged in.");
        }
    }

    public void sign_out(String username) {
        for (User user : users_logged_in) {
            if (user.getUsername().equals(username)) {
                users_logged_in.remove(user);
                System.out.println("User " + user.getName() + " has logged out.\n");
                return;
            }
        }
        System.out.println("User is not logged in.");
    }

    /**
     * Method to create a course.
     * If the user is not logged in, the course is not created.
     * If the user is not a lecturer or practitioner, the course is not created.
     * If the course is created successfully, it is added to the list of courses.
     * The course is also added to the list of courses the lecturer or practitioner is teaching.
     */

    public Course createCourse(User user, String courseType, String courseName, Integer courseNumber, int totalSeats) {
        if (!users_logged_in.contains(user)) {
            System.out.println("User is not logged in.");
            return null;
        }
        if (user instanceof Lecturer || user instanceof Practitioner) {
            Course course = CourseFactory.getCourse(courseType, courseName, courseNumber, totalSeats);
            if (course == null) {
                return null;
            }
            courses.add(course);
            ((FacultyMember) user).addCourse(course);
            System.out.println("Course " + courseName + " has been created.\n");
            return course;
        } else {
            System.out.println("User is not authorized to create a course.\n");
            return null;
        }
    }

    /**
     * Method to delete a course.
     * If the user is not logged in, the course is not deleted.
     * If the user is not a lecturer or practitioner, the course is not deleted.
     * If the course is deleted successfully, it is removed from the list of courses.
     * The course is also removed from the list of courses the lecturer or practitioner is teaching.
     */

    public void delete_course(User user, Course course) {
        if (!users_logged_in.contains(user)) {
            System.out.println("User is not logged in.");
            return;
        }
        if (user instanceof Lecturer || user instanceof Practitioner) {
            courses.remove(course);
            ((FacultyMember) user).removeCourse(course);
            System.out.println("Course " + course.getCourseName() + " has been deleted.");
        } else {
            System.out.println("User is not authorized to delete a course.");
        }
    }

    /**
     * Method to print the details of all courses.
     */
    public void print_course_details() {
        for (Course course : courses) {
            course.printCourseDetails();
        }
    }

    /**
     * Method to enter a course.
     * If the user is not logged in, the user is not allowed to enter the course.
     * If the user is not a student, the user is not allowed to enter the course.
     * If the user is a student, the student is added to the course.
     */
    public void enter_course(User user, Course course) {
        if (!users_logged_in.contains(user)) {
            System.out.println("User is not logged in.");
            return;
        }
        if (user instanceof Student) {
            course.enterCourse((Student) user);
        } else {
            System.out.println("User is not a student.");


        }
    }

    /**
     * Method to exit a course.
     * If the user is not logged in, the user is not allowed to exit the course.
     * If the user is not a student, the user is not allowed to exit the course.
     * If the user is a student, the student is removed from the course.
     */

    public void exit_course(User user, Course course) {
        if (!users_logged_in.contains(user)) {
            System.out.println("User is not logged in.");
            return;
        }
        if (user instanceof Student) {
            course.exitCourse((Student) user);
        } else {
            System.out.println("User is not a student.");
        }
    }


}


