package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by amit on 3/11/18.
 * <p>
 * // 3
 * // 17
 * // 27 4 25 6 6 1 27 22 19 29 6 9 36 24 6 15 5
 * // 8
 * // 43 34 2 8 17 5 11 8
 * // 30
 * // 20 17 42 25 32 32 30 32 37 9 2 33 31 17 14 40 9 12 36 21 8 33 6 6 10 37 12 26 21 3
 * 1
 * 30
 * 20 17 42 25 32 32 30 32 37 9 2 33 31 17 14 40 9 12 36 21 8 33 6 6 10 37 12 26 21 3
 */
public class ArrayEquilibriumTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        ArrayEquilibriumTest obj = new ArrayEquilibriumTest();

        while (testCase-- > 0) {
            int size = Integer.parseInt(br.readLine());
            int[] array = new int[size];
            // to read multiple integers line
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            for (int i = 0; i < size; i++) {
                array[i] = Integer.parseInt(strs[i]);
            }

            System.out.println(obj.findEquilibriumPoint(array));

        }
    }

    public int findEquilibriumPoint(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int startIndex = 0;
        int endIndex = array.length - 1;
        int leftSum = 0, rightSum = 0;

        while (startIndex < endIndex) {
            if (leftSum < rightSum) {
                leftSum += array[startIndex++];
            } else {
                rightSum += array[endIndex--];
            }

        }

        if (leftSum == rightSum && endIndex - startIndex == 0) {
            return array[startIndex];
        } else {
            return -1;
        }

    }
}
