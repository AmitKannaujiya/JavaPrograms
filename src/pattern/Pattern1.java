package pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by amit on 12/11/18.
 */
public class Pattern1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int size = Integer.parseInt(br.readLine());

            Pattern1 obj = new Pattern1();
            obj.printPattern(size);

        }

        Pattern1 p = null;
        p.foo(); // here at compile time , foo() is tested as static method,
        // so, p.foo() =>  is optimised by compiler as Pattern1.foo()
    }

//    public static String toString(){
//        System.out.println("Test toString called");
//        return "";
//    }

    public static String foo(){
        System.out.println("Test foo called");
        return "";
    }

    private void printPattern(int size) {
        for (int i = size; i >0; i--) {
            for (int j = size; j>0; j--) {
                for (int k = i; k > 0; k--) {
                    System.out.print(j +" ");
                }
            }
            System.out.println();
        }
    }
}
