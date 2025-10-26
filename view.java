package View;

import java.util.*;
import Controller.StudentDAO;
import Model.Student;

public class StudentApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n=== STUDENT MANAGEMENT MENU ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Department: ");
                    String dept = sc.next();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    dao.addStudent(new Student(name, dept, marks));
                    System.out.println("✅ Student added successfully!");
                    break;

                case 2:
                    for (Student s : dao.getAllStudents()) {
                        System.out.println(s.getStudentID() + " | " + s.getName() + " | " +
                                           s.getDepartment() + " | " + s.getMarks());
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to update: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new marks: ");
                    double newMarks = sc.nextDouble();
                    dao.updateStudent(id, newMarks);
                    System.out.println("✅ Marks updated!");
                    break;

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int delId = sc.nextInt();
                    dao.deleteStudent(delId);
                    System.out.println("✅ Student deleted!");
                    break;

                case 5:
                    System.out.println("👋 Exiting...");
                    sc.close();
                    System.exit(0);
            }
        }
    }
}
