import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private int age;
    private String grade;

    // Constructor
    public Student(String id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Remove Student");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    viewAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Add a new student
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(id, name, age, grade);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Update an existing student
    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();

        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.print("Enter new Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new Age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter new Grade: ");
                String grade = scanner.nextLine();

                student.setName(name);
                student.setAge(age);
                student.setGrade(grade);
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Remove a student
    private static void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        String id = scanner.nextLine();

        for (Student student : students) {
            if (student.getId().equals(id)) {
                students.remove(student);
                System.out.println("Student removed successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // View all students
    private static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\nList of Students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}