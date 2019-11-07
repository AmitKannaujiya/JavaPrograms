package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by amit on 14/11/18.
 */
public class JumpCloud {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int steps = 0, j = 0;
        if (c.length == 1) {
            if (c[j] == 0)
                return steps++;
            return -1;
        }
        for (int i = 1; i < c.length; i++) {
            if (i + 1 == c.length) {
                return ++steps;
            }
            if (c[i] == 0 && c[i + 1] == 0) {
                j = i + 1;
                steps++;
            } else if (c[i] == 0 && c[i + 1] == 1) {
                j = i;
                steps++;
            } else if (c[i] == 1 && c[i + 1] == 0) {
                j = i + 1;
                steps++;
            }

            i = j;

        }

        return steps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int testCase = Integer.parseInt(br.readLine());

        //while (testCase-- > 0) {
        int size = Integer.parseInt(br.readLine());
        int[] array = new int[size];
        String line = br.readLine();
        String[] strs = line.trim().split("\\s+");
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(strs[i]);
        }

        System.out.println(jumpingOnClouds(array));
    }
}
