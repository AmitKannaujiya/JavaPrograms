package dp;

public class MinimumNoOfJump {
    public static void main(String[] args) {
        int array [] =  new int[]{2,3,1,1,4};
        MinimumNoOfJump obj = new MinimumNoOfJump();
        System.out.println(obj.minimumNoOfJump(array,0,0));
        int[] array2 = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int[] dp =new int[array2.length];
        for(int i =0 ; i < array2.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        System.out.println(obj.minJumps(array2, 0, 0, dp));
    }


    public int minimumNoOfJump(int[] array) {
        return minimumNoOfJump(array, 0, 0);

    }

    public int minJumps(int[] array, int index, int jump, int[] dp) {
        if(array.length-1 <= index) {
            return jump;
        }
        int paths = array[index];
        if(paths == 0) {
            return 0;
        }
        if(dp[index] != Integer.MAX_VALUE) {
            //return dp[index];
        }

        int min = Integer.MAX_VALUE;
        for(int i=1; i<=paths; i++) {
            int j = minJumps(array, index + i, jump + 1, dp);
            if(j == 0) {
                j = Integer.MAX_VALUE;
            }
            min = Math.min(min, j);

        }
        dp[index] = min;
        return min;
    }

    private int minimumNoOfJump(int[] array, int start, int cost) {
        if(start ==array.length-1) {
            return cost;
        }
        if(start==0){
            return -1;
        }
        int jumps= array[start];
        int lastMax= Integer.MAX_VALUE;
        for (int i=1;i< jumps; i++){
            int jump=minimumNoOfJump(array, start+i,cost+1);
            lastMax=Math.max(jump, lastMax);

        }



        return lastMax;
    }
}
