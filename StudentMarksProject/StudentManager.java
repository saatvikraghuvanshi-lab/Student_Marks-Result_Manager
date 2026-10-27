public class StudentManager {
    private Student[] students = new Student[50];
    private int count = 0;

public void addStudent(Student s){  //M1
    if (count >= students.length) {
        System.out.println("Student list is full.");
        return;
    }
    for (int i = 0; i < count; i++) {
        if (students[i].getRollNumber() == s.getRollNumber()) {
            System.out.println("Roll number already exists.");
            return;
        }
    }
    students[count] = s;
    count++;

    System.out.println("Student added successfully.");
    }

public void displayAllStudents() {   //M2
    if (count == 0) {
        System.out.println("No students to display.");
        return;
    }
    for (int i = 0; i < count; i++) {
        students[i].DisplayStudentDetails();
        System.out.println("--------------------");
    }
 }

public Student findStudent(int rollNumber) {   //M3
    for (int i = 0; i < count; i++) {
        if (students[i].getRollNumber() == rollNumber) {
            return students[i];
        }
    }
    return null;
 }

 public void updateStudentMarks(int rollNumber, int mark1, int mark2, int mark3){  //M4
    Student s = findStudent(rollNumber);
    if (s != null) {
        s.updateMarks(mark1, mark2, mark3);
        System.out.println("Marks updated successfully.");
    } else {
        System.out.println("Student not found.");
    }
 }

 public void displayTopper(){
    if(count==0){
        System.out.println("No students to display.");
        return;
    }
    int highestTotal = students[0].calculateTotalMarks();

    for(int i=1; i<count; i++){
        int total = students[i].calculateTotalMarks();
        if(total>highestTotal){
            highestTotal = total;
        }
    }
    System.out.println("Highest Total Marks: " + highestTotal);
    System.out.println("Topper Details:");

    for(int i=0; i<count; i++){
        if(students[i].calculateTotalMarks() == highestTotal){
            students[i].DisplayStudentDetails();
            System.out.println("--------------------");
        }
    }
 }

}
