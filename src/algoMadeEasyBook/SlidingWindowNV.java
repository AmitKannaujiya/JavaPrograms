package algoMadeEasyBook;

import Utills.Utills;

public class SlidingWindowNV {

    public static void main(String[] args) {
        SlidingWindowNV obj =new SlidingWindowNV();
        int[] array = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result =obj.maxSlidingWindow(array, k);
        Utills.printArray(result);
        Utills.printArray(obj.maxSlidingWindow_Slid(array,k));

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result= new int[nums.length-k+1];
        for (int i = 0; i < nums.length - k +1; i++) {
            int max= nums[i];
            for (int j =1; j<k;j++) {
                if(nums[i+j] > max) {
                    max = nums[i+j];
                }
            }
            result[i] = max;
        }
        return result;
    }
    public int[] maxSlidingWindow_Slid(int[] nums, int k) {
        int[] result= new int[nums.length-k+1];
        int i = 0;
        int j = 0;
        int len = nums.length;
        int [] max = new int[k];
        int p = 0;
        while (j <len) {
            max[p%k] = nums[j];
            if(j-i+1 < k) {

            } else {
                result[i]= Utills.maxElementOfArray(max);
                i++;
            }
            j++;
            p++;
        }
        return result;
    }
}
