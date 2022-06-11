package algoMadeEasyBook;

import java.util.HashMap;

public class MinPositiveNo {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 6, 4, 1, 2}));
        //System.out.println(new Exception());
        System.out.println(solution(new int[]{3, 4, -1, 1}));
        System.out.println(solution(new int[]{1, 0, 2}));
        System.out.println(solution(new int[]{2, 3, 7, 6, 8, -1, -10, 15}));
        System.out.println(firstMissingPositive(new int[]{1, 0, 2}));
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));

    }

    public static int solution(int[] A) {
        int missing = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                map.put(A[i], A[i]);
            }
        }
        if (map.size() == 0) {
            return missing;
        }
        for (int no : map.keySet()) {
            if (no - missing >= 1) {
                return missing;
            }
            missing++;
        }
        return missing;
    }

    public static int firstMissingPositive(int[] nums) {
        int k=0;
        int m = 1;

        for(int i=0; i<nums.length; i++){
            if(k < nums[i]) {
                k=nums[i];
            }
        }
        int[] d=new int[k+2];
        for(int i=0;i<nums.length; i++) {
            if(nums[i] > 0) {
                d[nums[i]] =1;
            }
        }
        for(int i=1; i<=k+1; i++) {
            if(d[i] == 0 ) {
                return i;
            }
        }
        return m;
    }
}
