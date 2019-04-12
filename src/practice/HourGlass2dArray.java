package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by amit on 14/11/18.
 */
public class HourGlass2dArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [][] array = new int[6][6];
        for (int j = 0; j < 6; j++) {
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            for (int i = 0; i < 6; i++) {
                array[j][i] = Integer.parseInt(strs[i]);
            }

        }
        System.out.println(hourglassSum(array));


    }

    // Complete the hourglassSum function below.
    //  ij ij+1 ij+2
    //      i+1,j+1 i+1,j+2
    //  i+2,j i+2,j+1
    static int hourglassSum(int[][] arr) {
        int maxSum= Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2]
                                    + arr[i+1][j+1]
                        + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                if(sum > maxSum)
                    maxSum = sum;
            }
        }
        return maxSum;
    }
}
