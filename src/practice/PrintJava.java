package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by amit on 18/11/18.
 */
public class PrintJava {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        ArrayEquilibriumTest obj = new ArrayEquilibriumTest();

        while (testCase-- > 0) {
            int size = 3;
            int[] array = new int[size];
//            // to read multiple integers line
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            for (int i = 0; i < size; i++) {
                array[i] = Integer.parseInt(strs[i]);
            }

            operations(array[0], array[1], array[2]);

            //System.out.println(forkJava(size));
            //forkJava(size);

        }
    }

    static void operations(int a, int b, int c){
        long power = power(a, b);
        System.out.println(power);
        System.out.println(power^c);
        System.out.println(power%c);

    }


    static long power(int a, int b) {
        long temp;

        if(b==0) {
            return 1;
        }
        temp = power(a, b/2);
        if(b%2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * a;
        }

    }


    // Function to find number of jumps
    // N : number inscribed on the last stone.
    // X : number on which we have to reach
    static void findJumps(long N, long X){

        long leftStep = X - 1;
        if(X%2 ==0 ) {
            leftStep=X;
        }
        if (leftStep > 0) {
            leftStep = leftStep/2;
        }


        long rightStep = N - X;

        if(N%2==0 ) {
            rightStep +=1;
        }else if(X%2==0) {
            rightStep-= 1;
        }

        if(rightStep >0) {
            rightStep /= 2;
        }

        System.out.println(leftStep > rightStep ? rightStep : leftStep);



    }


    static void forkJava(int N){

        if(N%15 == 0) {
            System.out.println("Fork Java");
        }else if(N%5 == 0) {
            System.out.println("Java");
        } else if(N%3 == 0) {
            System.out.println("Fork");
        }

    }
}
