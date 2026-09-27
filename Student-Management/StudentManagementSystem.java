import java.util.ArrayList;
import java.util.Scanner;

class Student {

    private int id;
    private String name;
    private int age;
    private String course;
    private String email;
    private double marks;

    public Student(int id, String name, int age, String course, String email, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void displayStudent() {
        System.out.println("--------------------------------------------");
        System.out.println("Student ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Course     : " + course);
        System.out.println("Email      : " + email);
        System.out.println("Marks      : " + marks);
        System.out.println("Grade      : " + calculateGrade());
    }

    public String calculateGrade() {

        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n============================================");
            System.out.println("       STUDENT MANAGEMENT SYSTEM");
            System.out.println("============================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("============================================");

            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("\nThank you for using Student Management System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Add Student
    static void addStudent() {

        try {

            System.out.println("\n========== ADD STUDENT ==========");

            System.out.print("Enter Student ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            // Check duplicate ID
            for (Student student : students) {
                if (student.getId() == id) {
                    System.out.println("Student ID already exists!");
                    return;
                }
            }

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Course: ");
            String course = scanner.nextLine();

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            System.out.print("Enter Marks: ");
            double marks = Double.parseDouble(scanner.nextLine());

            if (marks < 0 || marks > 100) {
                System.out.println("Marks should be between 0 and 100.");
                return;
            }

            Student student =
                    new Student(id, name, age, course, email, marks);

            students.add(student);

            System.out.println("\nStudent added successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input! Student was not added.");
        }
    }

    // View Students
    static void viewStudents() {

        System.out.println("\n========== ALL STUDENTS ==========");

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            student.displayStudent();
        }

        System.out.println("--------------------------------------------");
        System.out.println("Total Students: " + students.size());
    }

    // Search Student
    static void searchStudent() {

        System.out.println("\n========== SEARCH STUDENT ==========");

        System.out.print("Enter Student ID: ");

        try {

            int id = Integer.parseInt(scanner.nextLine());

            for (Student student : students) {

                if (student.getId() == id) {
                    System.out.println("\nStudent Found!");
                    student.displayStudent();
                    return;
                }
            }

            System.out.println("Student with ID " + id + " not found.");

        } catch (Exception e) {
            System.out.println("Invalid Student ID.");
        }
    }

    // Delete Student
    static void deleteStudent() {

        System.out.println("\n========== DELETE STUDENT ==========");

        System.out.print("Enter Student ID: ");

        try {

            int id = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < students.size(); i++) {

                if (students.get(i).getId() == id) {

                    students.remove(i);

                    System.out.println("Student deleted successfully!");
                    return;
                }
            }

            System.out.println("Student with ID " + id + " not found.");

        } catch (Exception e) {
            System.out.println("Invalid Student ID.");
        }
    }
}
