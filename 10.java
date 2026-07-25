import java.util.*;

class Student {
    int id;
    String name;
    String course;
    double marks;

    Student(int id, String name, String course, double marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Course: " + course +
               ", Marks: " + marks;
    }
}

public class StudentRecordManagement {

    static ArrayList<Student> studentList = new ArrayList<>();
    static HashMap<Integer, Student> studentMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    // Add Student
    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (studentMap.containsKey(id)) {
            System.out.println("Student ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        Student s = new Student(id, name, course, marks);
        studentList.add(s);
        studentMap.put(id, s);

        System.out.println("Student Added Successfully.");
    }

    // Display Students
    static void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No Records Found.");
            return;
        }

        System.out.println("\nStudent Records:");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    // Search Student
    static void searchStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        if (studentMap.containsKey(id))
            System.out.println(studentMap.get(id));
        else
            System.out.println("Student Not Found.");
    }

    // Update Student
    static void updateStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!studentMap.containsKey(id)) {
            System.out.println("Student Not Found.");
            return;
        }

        Student s = studentMap.get(id);

        System.out.print("Enter New Name: ");
        s.name = sc.nextLine();

        System.out.print("Enter New Course: ");
        s.course = sc.nextLine();

        System.out.print("Enter New Marks: ");
        s.marks = sc.nextDouble();

        System.out.println("Student Updated Successfully.");
    }

    // Delete Student
    static void deleteStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        if (!studentMap.containsKey(id)) {
            System.out.println("Student Not Found.");
            return;
        }

        Student s = studentMap.remove(id);
        studentList.remove(s);

        System.out.println("Student Deleted Successfully.");
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter Your Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println("Program Ended.");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
