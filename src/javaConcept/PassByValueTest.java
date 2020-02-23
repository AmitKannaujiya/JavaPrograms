package javaConcept;


public class PassByValueTest {
    class  People {
        public String name ;
        People(String name) {
            this.name = name;
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello World");
        int i = 10;
        foo(i);
        System.out.println(i);
        Double d = 3.4;
        String s = "Amit";
        StringBuilder sb = new StringBuilder("Kumar");
        PassByValueTest obj = new PassByValueTest();
        People p = null;
        obj.testReferences(d, s, sb, p);
        System.out.println("d =" + d +" s="+s+" sb=" + sb.toString() );
    }

    void testReferences(Double d, String s, StringBuilder sb, People p) {
        d = 4.5;
        s += " Kumar";
        sb.append(" MB");
        p = new People("Amit Kumar");
        d = null;
        s = null;
        sb = null;
    }



    static void foo(int i) {
        i = 20;
    }
}
