


class Person {

    String name;
    public Person(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

}

class Student extends Person {

    String age;
    public Student(String age) {
        super("Ram");
        this.age =age;
    }

    @Override
    public String toString() {
       return  "Name: " + this.getName() + " Age :" +this.age;
    }
}


public class ConstructorChaining {

    public static void main(String[] args) {
        Student student = new Student("12");
        System.out.println(student.toString());
    }

}
