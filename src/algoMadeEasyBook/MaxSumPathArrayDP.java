package algoMadeEasyBook;

import Utills.Utills;

public class MaxSumPathArrayDP {

    public static void main(String[] args) {
        int a[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(goUtills(0, 0, a));
        int b[][] = {
                {1, 1, 3},
                {5, 1, 7},
                {9, 0, 2}
        };
        System.out.println(maxProductPath(b, 2, 2));

    }

    static long maxProdPathUtils(int a[][], int i, int j, int n, int m, int cache[][]) {
        int ans = 1;
        if (i == n + 1 || j == m + 1) {
            return ans;
        }
        if (cache[i][j] > 0) {
            return cache[i][j];
        }
        if (i <= m && j <= n) {
            ans *= a[i][j] * Math.max(maxProdPathUtils(a, i + 1, j, n, m, cache), maxProdPathUtils(a, i, j + 1, n, m, cache));
        } else if (i <= m) {
            ans *= a[i][j] * maxProdPathUtils(a, i + 1, j, n, m, cache);
        } else {
            ans *= a[i][j] * maxProdPathUtils(a, i, j + 1, n, m, cache);
        }

        return cache[i][j] = ans;
    }

    static long maxProductPath(int[][] a, int n, int m) {

        int[][] cache = new int[n + 1][m + 1];
        return maxProdPathUtils(a, 0, 0, n, m, cache);
    }

    private static int goUtills(int i, int j, int[][] a) {
        int[][] dp = new int[4][4];
        return go(i, j, a, dp);
    }

    private static int go(int i, int j, int[][] a, int[][] dp) {
        int ans = 0;
        if (j == 4 || i == 4) {
            return ans;
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        if (i <= 3 && j <= 3) {
            ans = a[i][j] + Utills.max(go(i, j + 1, a, dp), go(i + 1, j, a, dp));
        } else if (i <= 3) {
            ans = a[i][j] + go(i + 1, j, a, dp);
        } else if (j <= 3) {
            ans = a[i][j] + go(i, j + 1, a, dp);
        }
        dp[i][j] = ans;
        return ans;
    }
}
