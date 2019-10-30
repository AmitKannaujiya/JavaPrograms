package algoMadeEasyBook;

import Utills.Utills;

public class MaxSumPathArrayDP {

    public static void main(String[] args) {
        int a[][] = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        System.out.println(goUtills(0,0, a));

    }

    private static int goUtills(int i, int j, int [][] a) {
        int [][]dp = new int[4][3];
        return go(i, j, a, dp);
    }

    private static int go(int i, int j, int [][] a, int [][]dp) {
        int ans =0;
        if(j==4 || i==4) {
            return ans;
        }
        if(dp[i][j] >0 ) {
            return dp[i][j];
        }
        if(i<=3 && j<=3) {
            ans = a[i][j] + Utills.max(go(i, j+1, a, dp), go(i+1, j,a, dp));
        } else if(i<=3) {
            ans = a[i][j] +  go(i+1, j,a, dp);
        } else if(j<=3){
            ans = a[i][j] + go(i, j+1, a, dp);
        }
        dp[i][j] = ans;
        return ans;
    }
}
