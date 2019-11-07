package algoMadeEasyBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1<= a, b <=10^12
public class HackerRankSampleTest {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();Thread t =new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        },"ait");
//        String[] strs = line.trim().split("\\s+");
//        long first = Long.parseLong(strs[0]);
//        long second = Long.parseLong(strs[1]);
//        long count = 1;
//        if(first> second) {
//            for (int i = 2; i <second ; i++) {
//                if(second %i == 0 && first%i==0) {
//                    count++;
//                }
//            }
//        } else {
//            for (int i = 2; i <first ; i++) {
//                if(second %i == 0 && first%i==0) {
//                    count++;
//                }
//            }
//        }
//        System.out.println(count);
        // long a=34;long b=51;System.out.println(solve(a , b));
        System.out.println("AMIT".substring(0, 2));
        System.out.println("AMIT".substring(0, 4));
        HackerRankSampleTest obj = new HackerRankSampleTest();

        System.out.println(obj.longestPalindrome("cbbd"));
        System.out.println(obj.longestPalindrome("babad"));
        System.out.println(obj.longestPalindrome("--"));

    }

    static long solve(long A, long B) {
        for (long i = 3; i <= A; i += 2) {
            if (A % i == 0 && B % i == 0 && checkPrime(i)) {
                return i;
            }
        }
        return -1;
    }

    static boolean checkPrime(long no) {
        for (long i = 2; i * i < no; i++) {
            if (no % i == 0) {
                return false;
            }
        }
        return true;
    }

    // My solution without dp
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int first = nums[0];
        int second = nums[1];
        int currentMax = Integer.MIN_VALUE;
        for (int i = 2; i < nums.length; i++) {
            currentMax = second;
            currentMax = Math.max(currentMax, nums[1] + first);
            first = second;
            second = currentMax;
        }
        return currentMax;
    }

    // My solution DP
    public int rob1(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int dp[] = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int ans = Integer.MIN_VALUE;
        int currentMax = Integer.MIN_VALUE;
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(Math.max(nums[i], nums[i] + dp[i - 2]), dp[i - 1]);
        }
        return dp[nums.length];
    }

    // Rachit solution dp
    public int rob2(int[] nums) {
        int dp[] = new int[nums.length + 2];

        for (int i = 0; i < nums.length; i++) {
            dp[i + 2] = dp[i + 1];
            dp[i + 2] = Math.max(dp[i + 2], nums[i] + dp[i]);
        }
        return dp[nums.length + 1];
    }

    public int rob3(int[] nums) {
        int cMax = 0, pMax = 0, ppMax = 0;
        for (int i = 0; i < nums.length; i++) {
            cMax = pMax;
            cMax = Math.max(cMax, nums[i] + ppMax);
            pMax = cMax;
            ppMax = pMax;
        }
        return cMax;
    }

//    public int countSubstrings(String s) {
//        int ans= 0;
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i; j < s.length() ; j++) {
//                ans += countPalindrom(i, j, s);
//            }
//        }
//        return ans;
//    }
//
//    private int countPalindrom(int i , int j, String s) {
//        if(i > j) return 1;
//        if(s.charAt(i) != s.charAt(j)) {
//            return 0;
//        }
//        return countPalindrom(i+1, j-1, s);
//    }

    public int countSubstrings(String s) {
        int ans = 0;
        int dp[][] = new int[s.length()][s.length()];
        int visited[][] = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                ans += countPalindrom(i, j, s, dp, visited);
            }
        }
        return ans;
    }

    private int countPalindrom(int i, int j, String s, int dp[][], int visited[][]) {
        if (i > j) {
            return 1;
        }
        if (visited[i][j] == 1) {
            return dp[i][j];
        }
        visited[i][j] = 1;
        if (s.charAt(i) != s.charAt(j)) {
            return dp[i][j] = 0;
        }
        return dp[i][j] = countPalindrom(i + 1, j - 1, s, dp, visited);
    }

    public String longestPalindrome(String s) {
        String str = "";
        int dp[][] = new int[s.length()][s.length()];
        //int visited[][] = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (checkValidPalindrome(i, j, s, dp)) {
                    if (str != null && str.length() < j - i + 1 || str.isEmpty()) {
                        str = s.substring(i, j + 1);
                    }
                }
            }
        }
        return str;
    }

    private boolean checkValidPalindrome(int i, int j, String s, int dp[][]) {
        if (i > j) {
            return true;
        }
        if (dp[i][j] == 1 || dp[i][j] == -1) {
            return dp[i][j] == 1;
        }

        if (s.charAt(i) != s.charAt(j)) {
            return (dp[i][j] = -1) == 1;
        }
        boolean result = checkValidPalindrome(i + 1, j - 1, s, dp);
        return (dp[i][j] = (result ? 1 : 0)) == 1;
    }

    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int cSu = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            cSu = Math.max(nums[i], nums[i] + cSu);
            ans = Math.max(ans, cSu);
        }
        return ans;
    }

}
