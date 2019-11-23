package array;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveAdjucent {
    public static void main(String[] args) throws IOException {
       // System.out.println(maxSumAdjacent(new int[] {3, 2, 1, 10}, 3, 0));
        checkDivisibilityOf3();

    }

    int removeElementEvenSome(int a[]) {

        return Math.min(removeElementEvenSome(a, a[0], 0), removeElementEvenSome(a, 0, 1));
    }

    int removeElementEvenSome(int a[], int sum, int mincount) {
        for (int i = 0; i < a.length; i++) {
            sum += a[i];


        }
        return  a[0];
    }

    static void checkDivisibilityOf3() throws IOException {
        int remainder = 0;
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(inputStream);
        System.out.println("Enter binary no to check divisibility from 3 :");
        while(true) {
            int input = Integer.parseInt(bf.readLine());
            if(input==1) {
                remainder = (remainder * 2 + 1) % 3;

            } else if(input == 0){
                remainder = (remainder * 2) % 3;
            } else {
                System.out.println("Exiting as non binary input");
                break;
            }

            if(remainder % 3 == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }
}
