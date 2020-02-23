package algoMadeEasyBook;

import dp.MaximumTipProplem;

public class TappingRainWaterLeetCode {

    public static void main(String[] args) {
        int input[] = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        TappingRainWaterLeetCode obj = new TappingRainWaterLeetCode();
        System.out.println(obj.getTappedWater(input));
        System.out.println(obj.getTappedWaterBruteForce(input));
        System.out.println(obj.getTappedWaterDP(input));

        input = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(obj.getTappedWater(input));
        System.out.println(obj.getTappedWaterDP(input));
        System.out.println(obj.getTappedWaterBruteForce(input));
    }

    private int getTappedWaterBruteForce(int[] input) {
        int totalWater = 0;
        int leftMax =0, rightMax =0;
        for (int i=0; i< input.length; i++) {
            leftMax = input[i];
            for (int j=0; j<i; j++) {
                leftMax = Math.max(leftMax, input[j]);
            }
            rightMax = input[i];
            for (int k = i+1; k<input.length; k++) {
                rightMax = Math.max(rightMax, input[k]);
            }
            int water = Math.min(leftMax, rightMax);
            totalWater += water - input[i];
        }
        return totalWater;
    }

    private int getTappedWaterDP(int[] input) {
        int totalWater = 0;
        int[] leftMax = new int[input.length];
        int[] rightMax = new int[input.length];
        leftMax[0] = input[0];
        for (int i=1; i<input.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], input[i]);
        }
        rightMax[input.length-1] = input[input.length-1];
        for (int i=input.length-2; i >=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], input[i]);
        }

        for (int i=0; i< input.length; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - input[i];
        }
        return totalWater;
    }

    private int getTappedWater(int[] input) {
        int left = 0;
        int right = input.length-1;
        int leftMax = 0, rightMax=0;
        int max =0;
        while (left < right) {
            leftMax = Math.max(leftMax, input[left]);
            rightMax = Math.max(rightMax, input[right]);
            if (leftMax < rightMax) {
                max += (leftMax - input[left]);
                left++;
            } else {
                max += (rightMax - input[right]);
                right--;
            }
        }
        return max;
    }
}
