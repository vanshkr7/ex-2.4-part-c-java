package Model;

public class Student {
    private int StudentID;
    private String Name;
    private String Department;
    private double Marks;

    public Student() {}

    public Student(String name, String dept, double marks) {
        this.Name = name;
        this.Department = dept;
        this.Marks = marks;
    }

    public int getStudentID() { return StudentID; }
    public void setStudentID(int id) { this.StudentID = id; }

    public String getName() { return Name; }
    public void setName(String name) { this.Name = name; }

    public String getDepartment() { return Department; }
    public void setDepartment(String dept) { this.Department = dept; }

    public double getMarks() { return Marks; }
    public void setMarks(double marks) { this.Marks = marks; }
}
