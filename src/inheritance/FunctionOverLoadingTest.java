package inheritance;

public class FunctionOverLoadingTest {
    public static void main(String[] args) {
        FunctionOverLoadingTest obj = new FunctionOverLoadingTest();
        obj.testInheritence();
    }
    void testInheritence() {
        C c = new C();
        c.show(1);
//        c.show(1, 2);
//        c.show(1, 2, 3);
    }

}



