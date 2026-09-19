package string.class_problems;

public class Course {

    String name;
    int credits;
    String instructor;

    // Constructor with only course name
    Course(String name) {
        this.name = name;
        this.credits = 0;
        this.instructor = "Not Assigned";
    }

    // Constructor with course name and credits
    Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
        this.instructor = "Not Assigned";
    }

    // Constructor with all details
    Course(String name, int credits, String instructor) {
        this.name = name;
        this.credits = credits;
        this.instructor = instructor;
    }

    void printCourse() {
        System.out.println(
                name + " | Credits: " + credits +
                " | Instructor: " + instructor
        );
    }

    public static void main(String[] args) {

        Course course1 = new Course("Java");

        Course course2 = new Course("Data Structures", 4);

        Course course3 =
                new Course("Computer Architecture", 3, "Dr. Kumar");

        course1.printCourse();
        course2.printCourse();
        course3.printCourse();
    }
}