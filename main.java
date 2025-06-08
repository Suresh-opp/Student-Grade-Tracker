import java.util.ArrayList;
import java.util.Collections; // Required for Collections.min and Collections.max
import java.util.Comparator;  // Required for custom comparator with Collections.min/max
import java.util.Scanner;

// Represents a single student
class Student {
    public String name;
    public String studentID;
    public double grade; // This will store the individual student's grade

    Student(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
        this.grade = 0.0; // Initialize grade
    }

    // Method to set a student's grade
    public void setGrade(double grade) {
        this.grade = grade;
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Name: " + name + ", Student ID: " + studentID + ", Grade: " + grade);
    }
}

// Manages a collection of students and performs operations on them
class School {
    private ArrayList<Student> students;
    private Scanner scanner; // Scanner for input

    public School() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to add a new student
    public void addStudent(String name, String studentID) {
        students.add(new Student(name, studentID));
    }

    // Method to input grades for all students
    public void inputGrades() {
        if (students.isEmpty()) {
            System.out.println("No students registered yet. Please add students first.");
            return;
        }

        System.out.println("\nEnter grades for each student:");
        for (Student student : students) {
            System.out.print("Enter grade for " + student.name + " (ID: " + student.studentID + "): ");
            double grade = scanner.nextDouble();
            student.setGrade(grade);
        }
    }

    // Method to calculate and display the average grade of all students
    public void calculateAndDisplayAverageGrade() {
        if (students.isEmpty()) {
            System.out.println("No students to calculate average from.");
            return;
        }

        double totalGrades = 0;
        for (Student student : students) {
            totalGrades += student.grade;
        }
        double average = totalGrades / students.size();
        System.out.println("\nAverage grade of all students: " + average);
    }

    // --- New Methods for Highest and Lowest Scores ---

    // Method to find and display the highest grade
    public void findAndDisplayHighestGrade() {
        if (students.isEmpty()) {
            System.out.println("No students to find the highest grade from.");
            return;
        }

        // Use Collections.max with a custom comparator to find the student with the highest grade
        Student highestScorer = Collections.max(students, Comparator.comparingDouble(s -> s.grade));
        System.out.println("\nHighest Grade: " + highestScorer.grade + " (Scored by: " + highestScorer.name + ")");
    }

    // Method to find and display the lowest grade
    public void findAndDisplayLowestGrade() {
        if (students.isEmpty()) {
            System.out.println("No students to find the lowest grade from.");
            return;
        }

        // Use Collections.min with a custom comparator to find the student with the lowest grade
        Student lowestScorer = Collections.min(students, Comparator.comparingDouble(s -> s.grade));
        System.out.println("Lowest Grade: " + lowestScorer.grade + " (Scored by: " + lowestScorer.name + ")");
    }

    // --- End New Methods ---

    // Method to display details of all students
    public void displayAllStudentDetails() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        System.out.println("\n--- All Student Details ---");
        for (Student student : students) {
            student.displayStudentDetails();
        }
        System.out.println("-------------------------");
    }

    // Close the scanner when done
    public void closeScanner() {
        scanner.close();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the School Management System!");

        School school = new School(); // Create an instance of the School class

        // Add some sample students
        school.addStudent("Suresh", "30");
        school.addStudent("Sathwik", "21");
        school.addStudent("Alice", "101");
        school.addStudent("Bob", "102");
        school.addStudent("Charlie", "103");


        // Input grades for the students
        school.inputGrades();

        // Display all student details (including their grades)
        school.displayAllStudentDetails();

        // Calculate and display the average grade
        school.calculateAndDisplayAverageGrade();

        // Find and display the highest grade
        school.findAndDisplayHighestGrade();

        // Find and display the lowest grade
        school.findAndDisplayLowestGrade();

        school.closeScanner(); // 
        
    }
}