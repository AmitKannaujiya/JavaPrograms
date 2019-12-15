package inheritance.sub;

import inheritance.B;
import inheritance.C;

public class PackageTest {
    public static void main(String[] args) {
        PackageTest obj = new PackageTest();
        obj.testPackage();
    }

    private void testPackage() {
        C c = new C();
        //c.show(1);
        B b = new B();
        //b.show(1, 6)
        D d = new D();
        //d.show(4);
    }

}
