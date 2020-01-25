package javaInterview;

public class EqualTest {
    public static void main(String[] args) {
        System.out.println("This will check equal test interview questions");
        EqualTest obj = new EqualTest();
        obj.equalTest();

    }

    private void equalTest() {
        Object f = new Object();
        Object s = new Object();
        System.out.println("f == s " + f == s); // false
        System.out.println("f equals s " + f.equals(s)); // false : check memory address
        Thread t1 = new Thread();
        Thread t2 = new Thread();

        System.out.println("t1 == t2 " + (t1 == t2)); // false
        System.out.println("t1 equals t2 " + t1.equals(t2)); // false : check memory address

        String s1 = new String("ABC");
        String s2 = new String("abc");
        String s3 = "ABC";
        String s4 = "abc";
        String s5 = new String(s3);
        String s6 = "abc";
        String s7 = s5.intern();
        String s8 = "s1 == s2 ABC";

        System.out.println("s1 == s2 "+ (s1 == s2)); // false
        System.out.println("s3 == s1 "+ (s3 == s1)); // true    String pool cache
        System.out.println("s2 == s4 "+ (s2 == s4)); // true
        System.out.println("s5 == s3 "+ (s5 == s3)); // false
        System.out.println("s6 == s4 "+ (s6 == s4)); // false
        System.out.println("s7 == s3 "+ (s7 == s3)); // true

        System.out.println("s5 == s3 "+ s5 == s3); // false
        System.out.println("s5 == s3 "+ (s5 == s3)); // s5 == s3 false

        System.out.println("s1 equals s2 "+ s1.equals(s2)); // false
        System.out.println("s1 equals s3 "+ s1.equals(s3)); // true
        System.out.println("s5 equals s3 "+ s5.equals(s3)); // true

        System.out.println(("s1 == s2 " + s3) == s8);

        String A = "test";
        String B = "test";
        System.out.println("A == B " + (A == B));

        B = "test".toUpperCase();
        System.out.println("A == B " + (A.equals(B)));

    }

}
