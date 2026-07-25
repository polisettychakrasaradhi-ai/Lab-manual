import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return id + " " + name + " " + department + " " + salary;
    }
}

public class EmployeeAnalytics {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(101, "Rahul", "IT", 60000),
                new Employee(102, "Anjali", "HR", 45000),
                new Employee(103, "Kiran", "IT", 75000),
                new Employee(104, "Sneha", "Finance", 50000),
                new Employee(105, "Ravi", "HR", 65000)
        );

        // Filter Employees (Salary > 50000)
        System.out.println("Employees with Salary > 50000:");
        employees.stream()
                .filter(e -> e.salary > 50000)
                .forEach(System.out::println);

        // Sort Employees by Salary
        System.out.println("\nEmployees Sorted by Salary:");
        employees.stream()
                .sorted((e1, e2) -> Double.compare(e1.salary, e2.salary))
                .forEach(System.out::println);

        // Group Employees by Department
        System.out.println("\nEmployees Grouped by Department:");
        Map<String, List<Employee>> group =
                employees.stream()
                        .collect(Collectors.groupingBy(e -> e.department));

        group.forEach((dept, empList) -> {
            System.out.println(dept + ":");
            empList.forEach(System.out::println);
        });

        // Summary Statistics
        DoubleSummaryStatistics stats =
                employees.stream()
                        .collect(Collectors.summarizingDouble(e -> e.salary));

        System.out.println("\nSalary Summary:");
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Minimum: " + stats.getMin());
        System.out.println("Maximum: " + stats.getMax());
    }
}
