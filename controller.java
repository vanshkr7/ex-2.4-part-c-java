package Controller;

import java.sql.*;
import java.util.*;
import Model.Student;

public class StudentDAO {
    private Connection con;

    public StudentDAO() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "your_password");
    }

    public void addStudent(Student s) throws Exception {
        String query = "INSERT INTO Student (Name, Department, Marks) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, s.getName());
        ps.setString(2, s.getDepartment());
        ps.setDouble(3, s.getMarks());
        ps.executeUpdate();
    }

    public List<Student> getAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Student");
        while (rs.next()) {
            Student s = new Student();
            s.setStudentID(rs.getInt("StudentID"));
            s.setName(rs.getString("Name"));
            s.setDepartment(rs.getString("Department"));
            s.setMarks(rs.getDouble("Marks"));
            list.add(s);
        }
        return list;
    }

    public void updateStudent(int id, double marks) throws Exception {
        String query = "UPDATE Student SET Marks=? WHERE StudentID=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setDouble(1, marks);
        ps.setInt(2, id);
        ps.executeUpdate();
    }

    public void deleteStudent(int id) throws Exception {
        String query = "DELETE FROM Student WHERE StudentID=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
