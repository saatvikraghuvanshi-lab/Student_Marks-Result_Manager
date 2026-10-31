
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentMarksGUI extends JFrame {

    private StudentManager manager = new StudentManager();

    private JTextField rollField = new JTextField(10);
    private JTextField nameField = new JTextField(10);
    private JTextField mark1Field = new JTextField(5);
    private JTextField mark2Field = new JTextField(5);
    private JTextField mark3Field = new JTextField(5);

    private DefaultTableModel tableModel;
    private JTable studentTable;

    public StudentMarksGUI() {

        setTitle("Student Marks & Result Manager");
        setSize(950, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        // Heading
        JLabel heading = new JLabel(
            "STUDENT MARKS & RESULT MANAGER",
            SwingConstants.CENTER
        );

        heading.setFont(new Font("Arial", Font.BOLD, 22));

        JPanel headingPanel = new JPanel(new BorderLayout());
        headingPanel.add(heading, BorderLayout.CENTER);

        // Input panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 8, 5, 8);
        gbc.anchor = GridBagConstraints.LINE_START;
        String[] labels = {
            "Roll Number:",
            "Student Name:",
            "Subject 1 Marks:",
            "Subject 2 Marks:",
            "Subject 3 Marks:"
        };

JTextField[] fields = {
    rollField, nameField, mark1Field, mark2Field, mark3Field
};

for (int i = 0; i < labels.length; i++) {

    gbc.gridx = 0;
    gbc.gridy = i;
    gbc.weightx = 0;
    gbc.fill = GridBagConstraints.NONE;

    inputPanel.add(new JLabel(labels[i]), gbc);

    gbc.gridx = 1;
    gbc.weightx = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;

    inputPanel.add(fields[i], gbc);
}

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 10));

        String[] buttonNames = {
            "Add", "View All", "Search",
            "Update", "Delete", "Topper"
        };

        for (String name : buttonNames) {

            JButton button = new JButton(name);

            if (name.equals("Add")) {
                button.addActionListener(e -> addStudent());
            }
            else if (name.equals("View All")) {
                button.addActionListener(e -> refreshTable());
            }
            else if (name.equals("Search")) {
                button.addActionListener(e -> searchStudent());
            }
            else if (name.equals("Update")) {
                button.addActionListener(e -> updateStudent());
            }
            else if (name.equals("Delete")) {
                button.addActionListener(e -> deleteStudent());
            }
            else if (name.equals("Topper")) {
                button.addActionListener(e -> showTopper());
            }

            buttonPanel.add(button);
        }

        // Input and button section
        JPanel topPanel = new JPanel(new BorderLayout(10, 18));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 15, 20));
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Student table
        String[] columns = {
            "Roll Number", "Name", "Subject 1",
            "Subject 2", "Subject 3", "Total",
            "Average", "Result"
        };

        tableModel = new DefaultTableModel(columns, 0);
        studentTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(studentTable);

        // Complete window layout
        JPanel northPanel = new JPanel(new BorderLayout(10, 15));
        northPanel.add(headingPanel, BorderLayout.NORTH);
        northPanel.add(topPanel, BorderLayout.CENTER);

        add(northPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    // Add student
    private void addStudent() {

        try {
            int roll = Integer.parseInt(rollField.getText());
            String name = nameField.getText().trim();

            int m1 = Integer.parseInt(mark1Field.getText());
            int m2 = Integer.parseInt(mark2Field.getText());
            int m3 = Integer.parseInt(mark3Field.getText());

            if (roll <= 0 || name.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Enter valid roll number and name.");
                return;
            }

            if (m1 < 0 || m1 > 100 || m2 < 0 || m2 > 100
                    || m3 < 0 || m3 > 100) {
                JOptionPane.showMessageDialog(this,
                    "Marks must be between 0 and 100.");
                return;
            }

            Student s = new Student(roll, name, m1, m2, m3);

            if (manager.addStudent(s)) {
                JOptionPane.showMessageDialog(this,
                    "Student added successfully!");
                refreshTable();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Duplicate roll number or student list full.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Enter valid numbers in all fields.");
        }
    }

    // Display students in table
    private void refreshTable() {

        tableModel.setRowCount(0);

        for (int i = 0; i < manager.getCount(); i++) {

            Student s = manager.getStudentAt(i);

            tableModel.addRow(new Object[] {
                s.getRollNumber(),
                s.getName(),
                s.getMark(0),
                s.getMark(1),
                s.getMark(2),
                s.calculateTotalMarks(),
                String.format("%.2f", s.calculateAverageMarks()),
                s.isPassed() ? "Pass" : "Fail"
            });
        }
    }

    // Clear input fields
    private void clearFields() {

        rollField.setText("");
        nameField.setText("");
        mark1Field.setText("");
        mark2Field.setText("");
        mark3Field.setText("");
    }

    // Search student
    private void searchStudent() {

        try {
            int roll = Integer.parseInt(rollField.getText());
            Student s = manager.findStudent(roll);

            if (s == null) {
                JOptionPane.showMessageDialog(this, "Student not found.");
            } else {
                refreshTable();

                JOptionPane.showMessageDialog(this,
                    "Name: " + s.getName()
                    + "\nTotal: " + s.calculateTotalMarks()
                    + "\nAverage: " + s.calculateAverageMarks()
                    + "\nResult: " + (s.isPassed() ? "Pass" : "Fail"));
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Enter a valid roll number.");
        }
    }

    // Update marks
    private void updateStudent() {

        try {
            int roll = Integer.parseInt(rollField.getText());
            int m1 = Integer.parseInt(mark1Field.getText());
            int m2 = Integer.parseInt(mark2Field.getText());
            int m3 = Integer.parseInt(mark3Field.getText());

            if (m1 < 0 || m1 > 100 || m2 < 0 || m2 > 100
                    || m3 < 0 || m3 > 100) {
                JOptionPane.showMessageDialog(this,
                    "Marks must be between 0 and 100.");
                return;
            }

            Student s = manager.findStudent(roll);

            if (s == null) {
                JOptionPane.showMessageDialog(this, "Student not found.");
            } else {
                manager.updateStudentMarks(roll, m1, m2, m3);
                refreshTable();
                JOptionPane.showMessageDialog(this, "Marks updated!");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter valid numbers.");
        }
    }

    // Delete student
    private void deleteStudent() {

        try {
            int roll = Integer.parseInt(rollField.getText());

            if (manager.deleteStudent(roll)) {
                refreshTable();
                clearFields();
                JOptionPane.showMessageDialog(this, "Student deleted!");
            } else {
                JOptionPane.showMessageDialog(this, "Student not found.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Enter a valid roll number.");
        }
    }

    // Find topper
    private void showTopper() {

        if (manager.getCount() == 0) {
            JOptionPane.showMessageDialog(this, "No students available.");
            return;
        }

        int highest = 0;
        StringBuilder result = new StringBuilder("Topper(s):\n");

        for (int i = 0; i < manager.getCount(); i++) {

            Student s = manager.getStudentAt(i);

            if (s.calculateTotalMarks() > highest) {
                highest = s.calculateTotalMarks();
            }
        }

        for (int i = 0; i < manager.getCount(); i++) {

            Student s = manager.getStudentAt(i);

            if (s.calculateTotalMarks() == highest) {
                result.append(s.getName())
                    .append(" - ")
                    .append(highest)
                    .append(" marks\n");
            }
        }

        JOptionPane.showMessageDialog(this, result.toString());
    }

    public static void main(String[] args) {
        new StudentMarksGUI();
    }
}
