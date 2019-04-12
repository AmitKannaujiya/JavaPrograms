package practice;

import java.util.Scanner;

/**
 * Created by amit on 2/11/18.
 * test case :
 * 2
 3
 1 2 3
 4
 -1 -2 -3 -4
 Output
 6
 -1
 */
public class kadaneAlgo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        kadaneAlgo obj = new kadaneAlgo();
        int count = 0;
        int[] output = new int[testCase];
        while (testCase-- > 0) {
            int size = scanner.nextInt();
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();

            }
            output[count++] = obj.maximumSumArray(array, size);
        }
        for (int o : output)
            System.out.println(o);
    }

    public int maximumSumArray(int[] array, int size) {

        int maximum_sum_so_far = 0;
        int maximum_sum= Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            maximum_sum_so_far+= array[i];


            if(maximum_sum_so_far > maximum_sum) {
                maximum_sum = maximum_sum_so_far;
            }

            if (maximum_sum_so_far<0)
                maximum_sum_so_far =0;

        }
        return maximum_sum;
    }

    public int maximumSumArray2(int[] array, int size) {
        int maximum_sum_so_far = array[0];
        int maximum_sum= Integer.MIN_VALUE;

        for (int i = 1; i < size; i++) {
            maximum_sum_so_far = Math.max(array[i], maximum_sum_so_far+ array[i]);
            maximum_sum = Math.max(maximum_sum_so_far, maximum_sum);
        }
        return maximum_sum;
    }
}
