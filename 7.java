import java.io.*;
import java.util.Scanner;

public class StudentMarksFile {

    static final String FILE_NAME = "students.txt";

    // Store student details
    public static void addStudent(String name, int marks) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME, true);
            fw.write(name + "," + marks + "\n");
            fw.close();
            System.out.println("Student record added successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    // Display all student records
    public static void viewStudents() {
        try {
            File file = new File(FILE_NAME);

            if (!file.exists()) {
                System.out.println("No records found.");
                return;
            }

            Scanner reader = new Scanner(file);

            System.out.println("\nStudent Records:");
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] record = data.split(",");
                System.out.println("Name: " + record[0] + "  Marks: " + record[1]);
            }
            reader.close();

        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }

    // Update student marks
    public static void updateMarks(String name, int newMarks) {
        try {
            File file = new File(FILE_NAME);
            File temp = new File("temp.txt");

            Scanner reader = new Scanner(file);
            FileWriter writer = new FileWriter(temp);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] record = line.split(",");

                if (record[0].equalsIgnoreCase(name)) {
                    writer.write(name + "," + newMarks + "\n");
                } else {
                    writer.write(line + "\n");
                }
            }

            reader.close();
            writer.close();

            file.delete();
            temp.renameTo(file);

            System.out.println("Student marks updated successfully.");

        } catch (Exception e) {
            System.out.println("Error updating file.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n----- Student Marks File Management -----");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Marks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    addStudent(name, marks);
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student Name to Update: ");
                    String updateName = sc.nextLine();

                    System.out.print("Enter New Marks: ");
                    int newMarks = sc.nextInt();

                    updateMarks(updateName, newMarks);
                    break;

                case 4:
                    System.out.println("Program Ended.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
