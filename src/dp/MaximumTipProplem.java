package dp;

import java.util.*;
import java.lang.*;
import java.io.*;

public class MaximumTipProplem {

    //input

//    2
//    5 3 3
//    1 2 3 4 5
//    5 4 3 2 1
//    8 4 4
//    1 4 3 2 7 5 9 6
//    1 2 3 6 5 4 9 8

//    output
//    21
//    43



    public static void main (String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            int N = Integer.parseInt(strs[0]);
            int X = Integer.parseInt(strs[1]);
            int Y = Integer.parseInt(strs[2]);
            int a[] = new int[N];
            int b [] =new int[N];
            String line3 = br.readLine();
            String[] strs3 = line3.trim().split("\\s+");
            for(int i=0; i< N; i++) {
                a[i] = Integer.parseInt(strs3[i]);
            }
            String line4 = br.readLine();
            String[] strs4 = line4.trim().split("\\s+");
            for(int i=0; i< N; i++) {
                b[i] = Integer.parseInt(strs4[i]);
            }
            System.out.println(getMaxTip(X, Y, N, a, b));
        }
    }

    private static int getMaxTip(int x, int y, int n, int[] A, int[] B) {
        int[][] dp = new int[x + 1][y + 1];

        dp[0][0] = 0;
        for (int i = 1;i <= x;i++) {
            dp[i][0] = (i <= n) ? dp[i - 1][0] + A[i - 1] : dp[i - 1][0];
        }

        for (int i = 1;i <= y;i++) {
            dp[0][i] = (i <= n) ? dp[0][i - 1] + B[i - 1] : dp[0][i - 1];
        }

        for (int i = 1;i <= x;i++) {
            for (int j = 1;j <= y;j++) {
                if (i + j <= n) {
                    dp[i][j] = Math.max(dp[i - 1][j] + A[i + j - 1], dp[i][j - 1] + B[i + j - 1]);
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0;i <= x;i++) {
            for (int j = 0;j <= y;j++) {
                if (i + j == n) {
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}
