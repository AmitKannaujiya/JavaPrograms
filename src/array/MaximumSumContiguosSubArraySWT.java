package array;

public class MaximumSumContiguosSubArraySWT {

    public static void main(String[] args) {
        MaximumSumContiguosSubArraySWT obj = new MaximumSumContiguosSubArraySWT();
        int[] array = new int[]{4,2,1,7,8,1,2,8,1,0};
        System.out.println(obj.getMaximumSumOfContiguosArray(array, 4));
    }

    public  int getMaximumSumOfContiguosArray(int [] array, int k) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < array.length; i++) {
            currentSum += array[i];
            if(i>= k - 1) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= array[i - (k-1)];
            }
        }
        return maxSum;
    }
}
