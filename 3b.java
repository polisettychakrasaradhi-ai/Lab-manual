// Java Program to demonstrate public, private, and protected access specifiers

class PiValue {

    // Public variable
    public double pi;

    // Private variable
    private double radius;

    // Protected method
    protected void setRadius(double r) {
        radius = r;
    }

    // Public method to store Pi value
    public void setPi() {
        pi = Math.PI;
    }

    // Public method to calculate area of a circle
    public double calculateArea() {
        return pi * radius * radius;
    }

    // Public method to display values
    public void display() {
        System.out.println("Value of Pi: " + pi);
        System.out.println("Radius: " + radius);
        System.out.println("Area of Circle: " + calculateArea());
    }
}

public class PiCalculator {
    public static void main(String[] args) {

        PiValue obj = new PiValue();

        obj.setPi();          // Store Pi value
        obj.setRadius(7);     // Protected method
        obj.display();        // Display results
    }
}
