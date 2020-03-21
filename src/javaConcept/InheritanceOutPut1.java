package javaConcept;

import java.io.FileNotFoundException;
import java.io.IOException;

public class InheritanceOutPut1 {
    public static void main(String[] args) {
        A a = new B();
        try {
            a.m1();

        } catch (Exception e) {

        }
    }

}

class A {
    public void m1() throws FileNotFoundException {
        System.out.println("A's m1()");
    }
}

class B extends A {
    @Override
    public void m1() throws InstantiationError {
        System.out.println("B's m1()");
    }
}
