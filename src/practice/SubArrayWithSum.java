package practice;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by amit on 2/11/18.
 */
public class SubArrayWithSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        SubArrayWithSum obj = new SubArrayWithSum();
        int count = 0;
        int[][] output = new int[testCase][2];
        while (testCase-- > 0) {
            int size = scanner.nextInt();
            int sum = scanner.nextInt();
            scanner.useDelimiter("\\n");
            String pattern = "####,####.###";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);

            String number = decimalFormat.format(123456789.123);
            System.out.println(number);


            int[] array = new int[size];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
                if(array[i] > max) {
                    max = array[i];
                }
            }
            max++;
            int[] output1 = obj.subArraySum(array, size, sum, (max > 0 ? max : 10));
            System.out.print(output1[0] + " " + output1[1]);
            System.out.println();
        }
//        for (int[] o : output)
//            System.out.print(o[0] + " " + o[1]);
    }

    public int [] subArraySum(int a[], int size, int sum, int max) {
        boolean [] map = new boolean[max+1];
        int [] output = new int[2];
        for (int i = 0; i < size; i++) {
            int temp = sum - a[i];
            if(temp < 0 || temp > max)
                continue;
            if(map[temp] == false) {
                map[a[i]] = true;
            } else {
                output[0] = a[i];
                output[1] = temp;
                break;
            }
        }
        return output;
    }
}
