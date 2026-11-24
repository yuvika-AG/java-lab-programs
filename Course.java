
import java.util.Scanner;

class Course {
    int courseId;
    String courseName;
    int credits;
    String courseType;
    int registrationLimit;

    static int total_num_stud_Enrolled = 0;

    Course(int id, String name, int credits,
           String type, int enrolled) {

        this.courseId = id;
        this.courseName = name;
        this.credits = credits;
        this.courseType = type;

        total_num_stud_Enrolled += enrolled;

        if (courseType.equalsIgnoreCase("Department")) {
            registrationLimit = 60;
        }
        else if (courseType.equalsIgnoreCase("AEC")) {
            registrationLimit = 90;
        }
    }

    void displayCourse() {
        System.out.println("\nCourse ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Credits: " + credits);
        System.out.println("Course Type: " + courseType);
        System.out.println("Registration Limit: " + registrationLimit);
    }

    static void displayTotalEnrollment() {
        System.out.println("\nTotal Students Enrolled: "
                           + total_num_stud_Enrolled);
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Course[] courses = new Course[3];

        for (int i = 0; i < 3; i++) {

            System.out.println("\nEnter Course " + (i + 1) + " Details:");

            System.out.print("Enter Course ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Course Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Credits: ");
            int credits = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Course Type (Department/AEC): ");
            String type = sc.nextLine();

            System.out.print("Enter Number of Students Enrolled: ");
            int enrolled = sc.nextInt();

            courses[i] = new Course(id, name, credits, type, enrolled);
        }

        System.out.println("\n----- COURSE DETAILS -----");

        for (int i = 0; i < 3; i++) {
            courses[i].displayCourse();
        }

        Course.displayTotalEnrollment();

        sc.close();
    }
}
