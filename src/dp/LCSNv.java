package dp;

public class LCSNv {
    public static void main(String[] args) {
        String x="abcefdh";
        String y = "abcdeih";

        int m = x.length();
        int n = y.length();
        LCSNv obj= new LCSNv();
        System.out.println("############### LCS  #################");
        System.out.println("############### Recursive Solution #################");
        System.out.println(obj.LCSRecursive(x, y, m-1, n-1));

        int [][] dp =new int[m+1][n+1];
//        for (int i = 0; i <= m; i++) {
//            dp[i][0] = 0;
//        }
//        for (int j = 0; j <= n; j++) {
//            dp[0][j] = 0;
//        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {
                dp[i][j] =-1;
            }
        }
        System.out.println("############### Bottom up Solution #################");
        obj.LCS_DP_Bottom_up(x, y, m-1, n-1, dp);
        System.out.println(dp[m][n]);

        System.out.println("############### Top down Solution:1 #################");
        obj.LCS_DP_top_down(x, y, m, n, dp);
        System.out.println(dp[m][n]);
        System.out.println("############### Top down Solution:2 #################");
        obj.printLCS(dp, x, y);
        System.out.println(obj.longestCommonSubsequence(x,y));

    }

    public int LCSRecursive(String x, String y, int m,int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (x.charAt(m) == y.charAt(n)) {
            return 1 + LCSRecursive(x,y, m-1,n-1);
        } else {
            return Math.max(LCSRecursive(x, y, m-1,n), LCSRecursive(x, y, m, n-1));
        }
    }

    public int LCS_DP_Bottom_up(String x, String y, int m,int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if(dp[m][n] != -1) {
            return dp[m][n];
        }
        if (x.charAt(m) == y.charAt(n)) {
            return dp[m][n] =1 + LCS_DP_Bottom_up(x,y, m-1,n-1,dp);
        } else {
            return dp[m][n] = Math.max(LCS_DP_Bottom_up(x, y, m-1,n, dp), LCS_DP_Bottom_up(x, y, m, n-1,dp));
        }
    }

    public int LCS_DP_top_down(String x, String y, int m,int n, int[][] dp) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); ++i)
            for (int j = 0; j < s2.length(); ++j)
                if (s1.charAt(i) == s2.charAt(j)) dp[i + 1][j + 1] = 1 + dp[i][j];
                else dp[i + 1][j + 1] =  Math.max(dp[i][j + 1], dp[i + 1][j]);
        return dp[s1.length()][s2.length()];
    }

    public void printLCS(int[][] dp, String x, String y) {
        int i = dp.length-1;
        int j =dp[0].length -1;
        String str ="";
        while (i !=0 || j!=0) {

            if(x.charAt(i-1) == y.charAt(j-1)) {
                str += x.charAt(i-1);
                i--;
                j--;
            } else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            } else {
                j--;
            }
        }
        System.out.println(str);
    }
}
