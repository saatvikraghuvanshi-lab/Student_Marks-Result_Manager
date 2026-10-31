
public class Student {

    private int rollNumber;
    private String name;
    private int[] marks;

    public Student(int rollNumber, String name, int mark1, int mark2, int mark3) {

        this.rollNumber = rollNumber;
        this.name = name;

        this.marks = new int[3];

        this.marks[0] = mark1;
        this.marks[1] = mark2;
        this.marks[2] = mark3;
    }

    public int calculateTotalMarks() {
        int total = 0;

        total = total + marks[0];
        total = total + marks[1];
        total = total + marks[2];

        return total;
    }

    public double calculateAverageMarks() {
        double average = calculateTotalMarks() / 3.0;
        return average;
    }

    public boolean isPassed() {
        if(marks[0] < 40 || marks[1] < 40 || marks[2] < 40) {
            return false;
        }
            return true;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public String getName() {
        return name;
    }
    public void updateMarks(int mark1, int mark2, int mark3) {
        this.marks[0] = mark1;
        this.marks[1] = mark2;
        this.marks[2] = mark3;
    }
    public void DisplayStudentDetails(){
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Mark 1: " + marks[0]);
        System.out.println("Mark 2: " + marks[1]);
        System.out.println("Mark 3: " + marks[2]);

        System.out.println("Total Marks: " + calculateTotalMarks());
        System.out.printf("Average Marks: %.2f%n", calculateAverageMarks());
        if(isPassed()) {
            System.out.println("Student has passed");
        } else {
            System.out.println("Student has failed");
        }
    }
    public int getMark(int index) {
        return marks[index];
    }
}

