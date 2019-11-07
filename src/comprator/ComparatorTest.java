package comprator;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by amit on 24/10/18.
 */
public class ComparatorTest {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        ComparatorTest obj = new ComparatorTest();
        obj.createEmployees(employees);
        System.out.println("*******before sorting*********");
        obj.print(employees);
        Collections.sort(employees, new EmployeeComprator());
        System.out.println("*******after sorting*********");
        obj.print(employees);

    }

    public void print(ArrayList<Employee> employees) {
        System.out.println(employees.toString());
    }

    public void createEmployees(ArrayList<Employee> employees) {
        Employee employee1 = new Employee("Amit", 30);

        Employee employee2 = new Employee("Amit", 33);

        Employee employee3 = new Employee("Amit", 28);

        Employee employee4 = new Employee("Anil", 30);

        Employee employee5 = new Employee("Aakriti", 31);

        employees.add(employee4);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee5);
    }
}
