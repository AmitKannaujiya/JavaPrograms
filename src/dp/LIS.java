package dp;

class LIS {

     public int lengthOfLIS(int[] nums) {
        int lis = 0;
        int[] lisArray = new int[nums.length];
        for (int i = 0; i < lisArray.length; i++) {
            lisArray[i] =1;
        }
        for(int i= 1;i< nums.length; i++) {

            for (int j = 0; j <i ; j++) {
                if(nums[i]  > nums[j]) {
                    lisArray[i] = Math.max(lisArray[i],lisArray[j] + 1);
                }
            }
        }

        for (int i = 0; i < lisArray.length; i++) {
            if(lis < lisArray[i]){
                lis = lisArray[i];
            }
        }
        return lis;
    }
    public static void main(String[] args) {
        LIS obj = new LIS();
        int array[] =new int[]{10,9,2,5,3,7,101,18};
        System.out.println(obj.lengthOfLIS(array));
    }
}