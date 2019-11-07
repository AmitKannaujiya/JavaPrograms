package comprator;

import java.util.Comparator;

/**
 * Created by amit on 24/10/18.
 */
public class Employee {

    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return getName() + " is of " + getAge() + " years old ";
    }

    //    @Override
//    public int compare(Employee employee1, Employee employee2) {
//        int compare = employee1.getName().compareTo(employee2.getName());
//        if(compare == 0) {
//            return employee1.getAge() - employee2.getAge();
//        }
//        return compare;
//    }
}
