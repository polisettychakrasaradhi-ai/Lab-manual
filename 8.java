import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationForm extends JFrame implements ActionListener {

    JLabel lblName, lblRoll, lblCourse;
    JTextField txtName, txtRoll;
    JComboBox<String> cmbCourse;
    JButton btnRegister;

    public StudentRegistrationForm() {

        // Labels
        lblName = new JLabel("Student Name:");
        lblRoll = new JLabel("Roll Number:");
        lblCourse = new JLabel("Course:");

        // Text Fields
        txtName = new JTextField();
        txtRoll = new JTextField();

        // Combo Box
        String[] courses = {"BCA", "B.Tech", "B.Sc", "MCA", "M.Tech"};
        cmbCourse = new JComboBox<>(courses);

        // Button
        btnRegister = new JButton("Register");

        // Layout
        setLayout(null);

        // Set Bounds
        lblName.setBounds(50, 50, 100, 30);
        txtName.setBounds(170, 50, 180, 30);

        lblRoll.setBounds(50, 100, 100, 30);
        txtRoll.setBounds(170, 100, 180, 30);

        lblCourse.setBounds(50, 150, 100, 30);
        cmbCourse.setBounds(170, 150, 180, 30);

        btnRegister.setBounds(140, 220, 120, 35);

        // Add Components
        add(lblName);
        add(txtName);
        add(lblRoll);
        add(txtRoll);
        add(lblCourse);
        add(cmbCourse);
        add(btnRegister);

        // Register Event
        btnRegister.addActionListener(this);

        // Frame Settings
        setTitle("Student Registration Form");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = txtName.getText();
        String roll = txtRoll.getText();
        String course = (String) cmbCourse.getSelectedItem();

        JOptionPane.showMessageDialog(
                this,
                "Student Registered Successfully!\n\n" +
                "Name: " + name +
                "\nRoll Number: " + roll +
                "\nCourse: " + course
        );
    }

    public static void main(String[] args) {
        new StudentRegistrationForm();
    }
}
