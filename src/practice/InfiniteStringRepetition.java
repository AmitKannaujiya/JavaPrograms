package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by amit on 14/11/18.
 */
public class InfiniteStringRepetition {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int testCase = Integer.parseInt(br.readLine());

        //while (testCase-- > 0) {
        String line = br.readLine();
        long n = Long.parseLong(br.readLine());
        //int[] array = new int[size];
        // to read multiple integers line


        System.out.println(repeatedString(line, n));
    }

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int strLength = s.length();
        int count = countA(s, ((strLength < n) ? strLength: (int)n));
        if(count == 0)
            return 0;

        long rem = n-strLength;
        long lCount = ((rem / strLength)*count) + count;
        int rest = (int)(rem % s.length());
        return lCount + countA(s, rest);
    }

    static int countA(String s, int length) {
        int count =0;
        for (int i = 0; i <length; i++) {
            if(s.charAt(i)== 'a') {
                count++;
            }
        }
        return count;
    }
}
