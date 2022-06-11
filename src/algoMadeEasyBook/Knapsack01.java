package algoMadeEasyBook;

public class Knapsack01 {
    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        Knapsack01 obj = new Knapsack01();
        //obj.knapsack(wt, val, W, n);


        n =3;
        W = 4;
        int [] val1 = new int[]{1, 2, 3};
        int [] wt1 = new int[]{4, 5, 1};
        obj.knapsack(wt1, val1, W,n);

    }

    public int knapsack(int[] wt, int[]val, int W, int n) {
        int[][] dp =new int[W+1][n+1];
        for( int i =1;i<=W; i++) {
            for(int j=1;j <=n; j++) {
                if(i - wt[j-1] >=0){
                    dp[i][j] = Math.max(val[j-1] + dp[i-wt[j-1]][j], dp[i-1][j]);
                } else {
                    dp[i][j] =dp[i-1][j];
                }
            }
        }
        return dp[W][n];
    }
}
