import java.sql.*;
import java.util.Scanner;

public class StudentDBMS {

    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASSWORD = "password";

    static Connection con;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            while (true) {
                System.out.println("\n===== Student Database Management System =====");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter Choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;

                    case 2:
                        viewStudents();
                        break;

                    case 3:
                        updateStudent();
                        break;

                    case 4:
                        deleteStudent();
                        break;

                    case 5:
                        con.close();
                        System.out.println("Program Closed.");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CREATE
    static void addStudent() throws SQLException {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        String sql = "INSERT INTO students VALUES (?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, course);
        ps.setDouble(4, marks);

        ps.executeUpdate();

        System.out.println("Student Added Successfully.");
    }

    // READ
    static void viewStudents() throws SQLException {

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM students");

        System.out.println("\nID\tName\tCourse\tMarks");

        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("course") + "\t" +
                    rs.getDouble("marks"));
        }
    }

    // UPDATE
    static void updateStudent() throws SQLException {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        System.out.print("Enter New Marks: ");
        double marks = sc.nextDouble();

        String sql = "UPDATE students SET marks=? WHERE id=?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, marks);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Student Updated Successfully.");
        else
            System.out.println("Student Not Found.");
    }

    // DELETE
    static void deleteStudent() throws SQLException {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM students WHERE id=?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Student Deleted Successfully.");
        else
            System.out.println("Student Not Found.");
    }
}
