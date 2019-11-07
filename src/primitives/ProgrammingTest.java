package primitives;

/**
 * Created by amit on 3/7/18.
 */
public class ProgrammingTest {

    public static void main(String[] args) {

        // test for === vs equals()
        String s1 = "Hello";
        String s2 = new String(s1);
        String s3 = "Hello";

        System.out.println(s1 + " equals " + s2 + "--> " + s1.equals(s2)); //true

        System.out.println(s1 + " == " + s2 + " --> " + (s1 == s2)); //false
        System.out.println(s1 + " == " + s3 + " --> " + (s1 == s3)); //true

        Boolean b = new Boolean(true);
        Boolean a = new Boolean(true);
        Boolean c = true;

        System.out.println(a + " equals " + b + "--> " + a.equals(b)); //true

        System.out.println(a + " == " + b + " --> " + (a == b)); //false
        System.out.println(a + " == " + c + " --> " + (a == c)); //true

    }
}
