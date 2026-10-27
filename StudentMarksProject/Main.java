import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student s1 = new Student(101, "Rahul Sharma", 75, 82, 36);
        Student s2 = new Student(102, "Priya Patel", 85, 90, 45);

        StudentManager manager = new StudentManager();

        manager.addStudent(s1);
        manager.addStudent(s2);

        int choice;

        do {
            System.out.println("\n===== STUDENT RESULT MANAGER =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Find Student");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Display Topper");
            System.out.println("6. Exit");

            System.out.print("Enter your choice (1-6): ");
            choice = sc.nextInt();

            switch (choice) {
                
                
case 1:
    System.out.print("Enter roll number: ");
    int newRollNumber = sc.nextInt();
    sc.nextLine();

    System.out.print("Enter name: ");
    String newName = sc.nextLine();

    System.out.print("Enter marks for subject 1 (0-100): ");
    int newMark1 = sc.nextInt();

    System.out.print("Enter marks for subject 2 (0-100): ");
    int newMark2 = sc.nextInt();

    System.out.print("Enter marks for subject 3 (0-100): ");
    int newMark2Subject3 = sc.nextInt();

    if (newMark1 < 0 || newMark1 > 100 ||
        newMark2 < 0 || newMark2 > 100 ||
        newMark2Subject3 < 0 || newMark2Subject3 > 100) {

        System.out.println("Invalid marks! Marks should be between 0 and 100.");

    } else {
        Student newStudent = new Student(
            newRollNumber, newName,
            newMark1, newMark2, newMark2Subject3
        );

        manager.addStudent(newStudent);
    }
    break;



                case 2:
                    System.out.println("\nDisplaying all students:");
                    manager.displayAllStudents();
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRollNumber = sc.nextInt();

                    Student found = manager.findStudent(searchRollNumber);

                    if (found != null) {
                        found.DisplayStudentDetails();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                
case 4:
    System.out.print("Enter roll number to update: ");
    int updateRoll = sc.nextInt();

    System.out.print("Enter marks for subject 1 (0-100): ");
    int updateMark1 = sc.nextInt();

    System.out.print("Enter marks for subject 2 (0-100): ");
    int updateMark2 = sc.nextInt();

    System.out.print("Enter marks for subject 3 (0-100): ");
    int updateMark3 = sc.nextInt();

    if (updateMark1 < 0 || updateMark1 > 100 ||
        updateMark2 < 0 || updateMark2 > 100 ||
        updateMark3 < 0 || updateMark3 > 100) {

        System.out.println("Invalid marks! Marks should be between 0 and 100.");

    } else {
        manager.updateStudentMarks(
            updateRoll, updateMark1, updateMark2, updateMark3
        );
    }
    break;


                case 5:
                    manager.displayTopper();
                    break;

                case 6:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
