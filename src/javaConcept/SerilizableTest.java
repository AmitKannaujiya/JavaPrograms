package javaConcept;

import java.io.*;

public class SerilizableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Object Serilization
        Employee employee = new Employee("Ram");
        employee.setId(1);
        Address address = new Address("14 janpath", "New Delhi");
        employee.setAddress(address);
        FileOutputStream fileOutputStream = new FileOutputStream("./employee.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(employee);
        objectOutputStream.close();
        fileOutputStream.close();
        //
        // Object deserilization
        FileInputStream fileInputStream = new FileInputStream("./employee.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
       Employee lastEmployee =  (Employee) objectInputStream.readObject();
       System.out.println("id =" + lastEmployee.getId() +", name=" + lastEmployee.getName());
       // deserilization
    }
}
