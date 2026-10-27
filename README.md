# Student Marks and Result Manager

A console-based Java application that manages student records, calculates total and average marks, determines pass or fail status, updates marks, and identifies the class topper.

## Mini Project Overview

The Student Marks and Result Manager is a mini-project developed using Java and Object-Oriented Programming (OOP) concepts. It provides a menu-driven interface through which users can add students, view records, search for students, update marks, and display the topper.

The application stores student records in an array during program execution.

## Features

- **Add Student:** Add a student using a roll number, name, and marks in three subjects.
- **Display All Students:** Display all student records with their marks, total, average, and result status.
- **Search Student:** Find a student using their roll number.
- **Update Marks:** Update the marks of an existing student.
- **Pass/Fail Calculation:** A student passes only when they score at least 40 marks in all three subjects.
- **Topper Identification:** Find and display the student or students with the highest total marks.
- **Input Validation:** Reject marks outside the range of 0 to 100 and prevent duplicate roll numbers.
- **Menu-Driven Interface:** Perform operations through a console menu.

## Technologies Used

- Java
- Object-Oriented Programming
- Java arrays
- `Scanner` for console input
- Conditional statements, loops, methods, and `switch-case`

## Project Structure

```text
Student-Marks-Result-Manager/
│
├── Main.java
├── Student.java
├── StudentManager.java
└── README.md
```

### File Descriptions

| File | Description |
|---|---|
| `Main.java` | Starts the application, displays the menu, accepts input, and handles user choices. |
| `Student.java` | Represents a student and calculates total marks, average marks, and pass/fail status. |
| `StudentManager.java` | Stores and manages student records, searches for students, updates marks, and identifies the topper. |

## Prerequisites

Install the Java Development Kit (JDK) and ensure that Java commands are available in your terminal.

Check your installation:

```bash
java -version
javac -version
```

## How to Run the Project

1. Clone this repository or download the project files.
2. Open a terminal in the project directory.
3. Compile the Java files:

```bash
javac Main.java Student.java StudentManager.java
```

4. Run the application:

```bash
java Main
```

5. Follow the menu displayed in the console.

## Menu Options

The application provides the following operations:

1. Add Student
2. Display All Students
3. Find Student
4. Update Student Marks
5. Display Topper
6. Exit

## Sample Student Records

The application initially creates two sample student objects.

| Roll Number | Name | Subject 1 | Subject 2 | Subject 3 | Total | Average | Result |
|---:|---|---:|---:|---:|---:|---:|---|
| 101 | Rahul Sharma | 75 | 82 | 36 | 193 | 64.33 | Fail |
| 102 | Priya Patel | 85 | 90 | 45 | 220 | 73.33 | Pass |

A student must score at least 40 marks in every subject to pass. Therefore, Rahul Sharma fails because he scored 36 marks in the third subject.

Priya Patel is initially the topper with 220 total marks.

## Object-Oriented Programming Concepts

This project demonstrates the following concepts:

- **Classes and Objects:** `Student` represents individual student records, while `StudentManager` manages those records.
- **Encapsulation:** Student fields are declared `private` and accessed through methods where required.
- **Constructors:** A parameterized constructor initialises a student's roll number, name, and marks.
- **Methods:** Separate methods perform calculations, search records, update marks, and display results.
- **Arrays:** An array stores the three subject marks, and another array stores up to 50 student objects.
- **Control Flow:** `if-else`, loops, `switch-case`, and `do-while` control program execution.

## Limitations

- Student records are stored in memory and are lost when the program terminates.
- The application supports a maximum of 50 student records.
- Each student has exactly three subjects.
- The application does not use a database or provide a graphical user interface.
- Some invalid inputs, such as non-numeric entries, are not comprehensively handled.

## Future Enhancements

Possible improvements include:

- Permanent storage using files or a database.
- Support for a configurable number of subjects.
- More comprehensive input validation.
- Student record deletion.
- Additional reports and rankings.
- A graphical user interface.

## Learning Objectives

This project provides practical experience with Java programming, object-oriented design, arrays, methods, input handling, conditional logic, and basic record management.

## Author

Developed as a Java Object-Oriented Programming mini-project.
