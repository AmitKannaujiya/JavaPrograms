package wrapper;

/**
 * Created by amit on 26/10/18.
 */
public class WrapperClassTest {

    public static void main(String[] args) {
        Integer nine = 9;
        Integer nine2 = Integer.valueOf("9");

        System.out.println(nine == nine2); // this profs the caching of Integer class , So always use

        Integer nine3 = new Integer(9);

        System.out.println(nine == nine3);

        Integer nine4 = 9;
        System.out.println(nine == nine4);

        try {
            System.out.println("Try");
            String p="" ;
            System.out.print(p.substring(0, 9));

        } catch (Exception e) {
            System.out.println("Catch");
            e.printStackTrace();

        } finally {
            System.out.println("finally");
        }


    }
}
