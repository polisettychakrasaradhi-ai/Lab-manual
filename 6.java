import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends Frame implements ActionListener {

    Label l1, l2, l3;
    TextField t1, t2, t3;
    Button add, sub, mul, div;

    public SimpleCalculator() {

        // Labels
        l1 = new Label("First Number:");
        l2 = new Label("Second Number:");
        l3 = new Label("Result:");

        // Text Fields
        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();
        t3.setEditable(false);

        // Buttons
        add = new Button("Add");
        sub = new Button("Subtract");
        mul = new Button("Multiply");
        div = new Button("Divide");

        // Set Layout
        setLayout(null);

        // Set Bounds
        l1.setBounds(50, 50, 100, 30);
        t1.setBounds(170, 50, 150, 30);

        l2.setBounds(50, 100, 100, 30);
        t2.setBounds(170, 100, 150, 30);

        l3.setBounds(50, 150, 100, 30);
        t3.setBounds(170, 150, 150, 30);

        add.setBounds(50, 220, 80, 40);
        sub.setBounds(140, 220, 80, 40);
        mul.setBounds(230, 220, 80, 40);
        div.setBounds(320, 220, 80, 40);

        // Add Components
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);

        add(add);
        add(sub);
        add(mul);
        add(div);

        // Register Event Handling
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        // Window Closing Event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setTitle("Simple AWT Calculator");
        setSize(450, 320);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        double num1 = Double.parseDouble(t1.getText());
        double num2 = Double.parseDouble(t2.getText());
        double result = 0;

        if (e.getSource() == add)
            result = num1 + num2;
        else if (e.getSource() == sub)
            result = num1 - num2;
        else if (e.getSource() == mul)
            result = num1 * num2;
        else if (e.getSource() == div) {
            if (num2 != 0)
                result = num1 / num2;
            else {
                t3.setText("Cannot Divide by Zero");
                return;
            }
        }

        t3.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
