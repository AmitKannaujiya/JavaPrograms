package practice;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountValley {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        boolean starting = false;
        int countValleys = 0;
        int sequence = 0;
        int oldSequence = sequence;
        for (char c : s.toCharArray()) {
            if (c == 'U') {
                sequence += 1;
            } else if (c == 'D') {
                sequence -= 1;
            }
            if (oldSequence == 0 && sequence == -1) {
                starting = true;
            } else if (oldSequence == -1 && sequence == 0) {
                if (starting) {
                    countValleys++;
                    starting = false;
                }
            }
            oldSequence = sequence;

        }
        return countValleys;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int testCase = Integer.parseInt(br.readLine());

        //while (testCase-- > 0) {
        int size = Integer.parseInt(br.readLine());
        //int[] array = new int[size];
        // to read multiple integers line
        String line = br.readLine();

        System.out.println(countingValleys(size, line));
    }
}
