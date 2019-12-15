package inheritance.sub;

import inheritance.C;

public class D extends C {
    void show(int a, int b, int c) {
        System.out.println("Class D");
        show(a);
    }
}
