
public class StudentManager {

    private Student[] students = new Student[50];
    private int count = 0;

    // M1: Add student
    public boolean addStudent(Student s) {

        if (count >= students.length) {
            return false;
        }

        for (int i = 0; i < count; i++) {
            if (students[i].getRollNumber() == s.getRollNumber()) {
                return false;
            }
        }

        students[count] = s;
        count++;

        return true;
    }

    // M2: Display all students
    public void displayAllStudents() {

        if (count == 0) {
            System.out.println("No students to display.");
            return;
        }

        for (int i = 0; i < count; i++) {
            students[i].DisplayStudentDetails();
            System.out.println("--------------------");
        }
    }

    // M3: Search student
    public Student findStudent(int rollNumber) {

        for (int i = 0; i < count; i++) {
            if (students[i].getRollNumber() == rollNumber) {
                return students[i];
            }
        }

        return null;
    }

    // M4: Update marks
    public void updateStudentMarks(int rollNumber, int mark1, int mark2, int mark3) {

        Student s = findStudent(rollNumber);

        if (s != null) {
            s.updateMarks(mark1, mark2, mark3);
            System.out.println("Marks updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // M5: Display topper
    public void displayTopper() {

        if (count == 0) {
            System.out.println("No students to display.");
            return;
        }

        int highestTotal = students[0].calculateTotalMarks();

        for (int i = 1; i < count; i++) {
            int total = students[i].calculateTotalMarks();

            if (total > highestTotal) {
                highestTotal = total;
            }
        }

        System.out.println("Highest Total Marks: " + highestTotal);
        System.out.println("Topper Details:");

        for (int i = 0; i < count; i++) {
            if (students[i].calculateTotalMarks() == highestTotal) {
                students[i].DisplayStudentDetails();
                System.out.println("--------------------");
            }
        }
    }

    // M6: Get number of students
    public int getCount() {
        return count;
    }

    // M7: Get student using index
    public Student getStudentAt(int index) {

        if (index >= 0 && index < count) {
            return students[index];
        }

        return null;
    }

    // M8: Delete student
    public boolean deleteStudent(int rollNumber) {

        for (int i = 0; i < count; i++) {

            if (students[i].getRollNumber() == rollNumber) {

                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }

                students[count - 1] = null;
                count--;

                return true;
            }
        }

        return false;
    }
}
