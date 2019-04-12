package comprator;

import java.util.Comparator;

/**
 * Created by amit on 24/10/18.
 */
public class EmployeeComprator implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
        int compare = employee1.getName().compareTo(employee2.getName());
        if(compare == 0) {
            return employee1.getAge() - employee2.getAge();
        }
        return compare;
    }
}
