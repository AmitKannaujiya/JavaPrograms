package practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amit on 16/12/18.
 */
public class MaximumSlidingWindowTest {

    public static void main(String[] args) {
        //int a[] = new int[] {1,3,-1,-3,5,3,6,7};
       // int k = 3;
        int a[] = new int[] {1, -1};
       // int b[] = maxSlidingWindow(a, 1);
        int k = 1;
        int b[] = maxSlidingWindow4(a, k);
        printArray(b);
    }

    static void printArray(int [] b) {
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]+ " ");
        }
    }

//    Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//    Output: [3,3,5,5,6,7]
    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        int window = 0;
        if(nums.length <= 1) {
            return nums;
        }

        int max = nums[0];
        for (int i = 0, j=i; i < nums.length; i++, j++) {
            if(nums[i] > max) {
                max = nums[i];
            }
            if ( j+1 == k ){
                integerArrayList.add(max);
                j--;
                max=nums[i];
            }
        }
        return integerArrayList.stream().mapToInt((i) -> i.intValue()).toArray();

    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        int window = 0;
        if(nums.length <= 1) {
            return nums;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0, j=0;i < nums.length; i++, j++, window++) {
            if(max < nums[j]) {
                max = nums[j++];
            }
            if(window == k-1) {
                integerArrayList.add(max);
                window = 0;
                if(nums[i-k-1] >= 1) {

                }
            }


        }
        return integerArrayList.stream().mapToInt((i) -> i.intValue()).toArray();

    }

    public static int[] maxSlidingWindow3(int[] nums, int k) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        int window = 0;
        if(nums.length <= 1) {
            return nums;
        }
        int max = nums[0];
        int sMax = max;
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > max) {
                sMax = max;
                max = nums[i];
            } else if(nums[i] > sMax) {
                sMax = nums[i];
            }

            if(i >= k-1) {
                integerArrayList.add(max);
            }

        }
        return integerArrayList.stream().mapToInt((i) -> i.intValue()).toArray();
    }

    public static int[] maxSlidingWindow4(int[] nums, int k) {
        if(nums.length <= 1) {
            return nums;
        }
        int[] b= new int[nums.length -k+1];
        int max = nums[0];
        for (int i = 0; i < k; i++) {
            if(max < nums[i]) {
                max = nums[i];
            }
        }

        int j = k;
        int i=1;
        b[0] = max;
        while (j < nums.length) {
            b[i] = maxOf(nums, i, j);
            i++;
            j++;
        }
        return b;
    }

    private static int maxOf(int[] nums, int i, int j) {
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            if(nums[k] > max) {
                max = nums[k];
            }
        }
        return max;
    }

}
