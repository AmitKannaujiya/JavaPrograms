package algoMadeEasyBook;

public class BuySellStock1LeetCode121 {
    public static void main(String[] args) {
        int array[] = {7,1,5,3,6,4};

        BuySellStock1LeetCode121 obj = new BuySellStock1LeetCode121();
        System.out.println(obj.getMaximumProfit(array));

        int array2[] = {7,6,4,3,1};
        System.out.println(obj.getMaximumProfit(array2));
    }

    int getMaximumProfit(int[] array) {
        int lastBuy = array[0];
        int [] dp =new int[array.length+1];
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i-1], array[i] - lastBuy);
            maxProfit = Math.max(maxProfit, array[i]- lastBuy);
            if(lastBuy > array[i]) {
                lastBuy = array[i];
            }
        }
        //return dp[array.length];
        return maxProfit < 0 ? 0 : maxProfit;
    }


}
