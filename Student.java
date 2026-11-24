
import java.util.Scanner;

class Student {
    int studentId;
    String studentName;
    int marks[] = new int[5];
    int total = 0;

    void calculateTotal() {
        total = 0;
        for (int i = 0; i < 5; i++) {
            total += marks[i];
        }
    }

    void displayDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);

        System.out.print("Marks: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(marks[i] + " ");
        }

        System.out.println("\nTotal Marks: " + total);
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student s[] = new Student[5];

        // Input details of 5 students
        for (int i = 0; i < 5; i++) {

            s[i] = new Student();

            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("Enter Student ID: ");
            s[i].studentId = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Student Name: ");
            s[i].studentName = sc.nextLine();

            System.out.println("Enter marks in 5 subjects:");

            for (int j = 0; j < 5; j++) {
                s[i].marks[j] = sc.nextInt();
            }

            s[i].calculateTotal();
        }

        // Find highest and lowest total
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < 5; i++) {

            if (s[i].total > s[maxIndex].total) {
                maxIndex = i;
            }

            if (s[i].total < s[minIndex].total) {
                minIndex = i;
            }
        }

        // Display all students
        System.out.println("\n----- ALL STUDENT DETAILS -----");

        for (int i = 0; i < 5; i++) {
            s[i].displayDetails();
            System.out.println("----------------------");
        }

        // Display highest scorer
        System.out.println("\n----- HIGHEST SCORING STUDENT -----");
        s[maxIndex].displayDetails();

        // Display lowest scorer
        System.out.println("\n----- LOWEST SCORING STUDENT -----");
        s[minIndex].displayDetails();

        // Additional Part: Store students scoring more than 450
        int count = 0;

        for (int i = 0; i < 5; i++) {
            if (s[i].total > 450) {
                count++;
            }
        }

        Student filtered[] = new Student[count];

        int k = 0;

        for (int i = 0; i < 5; i++) {
            if (s[i].total > 450) {
                filtered[k] = s[i];
                k++;
            }
        }

        System.out.println("\n----- STUDENTS WITH MORE THAN 450 MARKS -----");

        for (int i = 0; i < filtered.length; i++) {
            filtered[i].displayDetails();
            System.out.println("----------------------");
        }

        sc.close();
    }
}
