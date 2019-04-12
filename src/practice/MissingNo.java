package practice;

import java.util.Scanner;

/**
 * Created by amit on 2/11/18.
 */
public class MissingNo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        MissingNo obj = new MissingNo();
        int count = 0;
        int[] output = new int[testCase];
        while (testCase-- > 0) {
            int size = scanner.nextInt();
            int[] array = new int[size-1];
            int sum = 0;
            int actualSum = (size * (size +1))/2;
            for (int i = 0; i < size-1; i++) {
                array[i] = scanner.nextInt();
                sum+= array[i];
            }
            output[count++] = actualSum - sum;
        }
        for (int o : output)
            System.out.println(o);
    }

}
