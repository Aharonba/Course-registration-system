public class main {

    public static void main(String[] args) {
        RegistrationSystem registrationSystem = RegistrationSystem.getInstance();

        //sign up users to the system

        //Students sign up to the system
        User david = registrationSystem.sign_up("David", 1, "david123", "123456", "Computer Science", "david@gmail.com", "Student", "0545526571");
        User ron = registrationSystem.sign_up("Ron", 2, "ron123", "123457", "Computer Science", "ron@gmail.com", "Student", "0545332571");
        User noa = registrationSystem.sign_up("Noa", 3, "noa123", "123451", "Computer Science", "noa@gmail.com", "Student", "0545521171");
        User gal = registrationSystem.sign_up("Gal", 4, "gal123", "123426", "Biology", "gal@gmail.com", "Student", "0540126571");
        User liron = registrationSystem.sign_up("Liron", 5, "liron123", "154456", "Biology", "liron@gmail.com", "Student", "0545526591");
        User hagit = registrationSystem.sign_up("Hagit", 6, "hagit123", "125456", "Civil Engineering", "hagit@gmail.com", "Student", "0545526271");
        User tamar = registrationSystem.sign_up("Tamar", 7, "tamar123", "121456", "Civil Engineering", "tamar@gmail.com", "Student", "0545519571");

        //Lecturers and Practitioners sign up to the system

        User dan = registrationSystem.sign_up("Dan", 8, "dan123", "153456", "Computer Science", "dan@gmail.com", "Lecturer", "0545521111");
        User michael = registrationSystem.sign_up("Michael", 9, "michael123", "000456", "Computer Science", "michael@gmail.com", "Practitioner", "0545526571");

        User eran = registrationSystem.sign_up("Eran", 10, "eran123", "152256", "Biology", "eran@gmail.com", "Lecturer", "0545521199");
        User elad = registrationSystem.sign_up("Elad", 11, "elad123", "001456", "Biology", "elad@gmail.com", "Practitioner", "0545126571");

        User oriya = registrationSystem.sign_up("Oriya", 12, "oriya123", "153256", "Civil Engineering", "oriya@gmail.com", "Lecturer", "0548521111");
        User daniel = registrationSystem.sign_up("Daniel", 13, "Daniel123", "010456", "Civil Engineering", "daniel@gmail.com", "Practitioner", "0545026571");

        //Lecturers and practitioners create new courses

        Course introduction_to_cs = registrationSystem.createCourse(dan, "Mandatory", "Computer science Introduction", 12121, 100);
        Course algorithms = registrationSystem.createCourse(dan, "Mandatory", "Algorithms", 22512, 100);

        Course biology = registrationSystem.createCourse(elad, "Mandatory", "Biology", 77683, 70);
        Course civil_engineering = registrationSystem.createCourse(oriya, "Mandatory", "Civil Engineering", 19824, 66);

        // students enter to courses
        registrationSystem.enter_course(david, introduction_to_cs);
        registrationSystem.enter_course(ron, introduction_to_cs);

        // student exit from courses
        registrationSystem.exit_course(david, introduction_to_cs);


        registrationSystem.enter_course(noa, algorithms);
        registrationSystem.enter_course(gal, biology);
        registrationSystem.enter_course(hagit, civil_engineering);


        //print course details
        registrationSystem.print_course_details();

        //Users log out from the system

        registrationSystem.sign_out("david123");
        registrationSystem.sign_out("ron123");
        registrationSystem.sign_out("noa123");


    }
}
