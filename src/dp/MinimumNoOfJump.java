package dp;

public class MinimumNoOfJump {
    public static void main(String[] args) {
        int array [] =  new int[]{2,3,1,1,4};
        MinimumNoOfJump obj = new MinimumNoOfJump();
        System.out.println(obj.minimumNoOfJump(array,0,0));

    }

    public int minimumNoOfJump(int[] array) {
        return minimumNoOfJump(array, 0, 0);

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
