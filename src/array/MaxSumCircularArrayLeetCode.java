package array;

public class MaxSumCircularArrayLeetCode {
    public static void main(String[] args) {
        MaxSumCircularArrayLeetCode obj = new MaxSumCircularArrayLeetCode();
        int [] array = new int[] {1,-2,3,-2};
        System.out.println(obj.maxSubarraySumCircular(array));
        System.out.println(obj.maxSubarraySumCircular1(array));
    }
    public int maxSubarraySumCircular(int[] A) {
        int maxSum = 0;
        int sum = 0;
        int currentSum = 0;
        for(int i=0; i < A.length; i++) {
            int c = A[i] * -1;
            sum += c;
            currentSum = Math.max( c, currentSum  + c);
            if(currentSum >  maxSum) {
                maxSum = currentSum;
            } else if(currentSum < 0) {
                currentSum = 0;
            }
        }
        return -1 * ( sum - maxSum);
    }

    public int maxSubarraySumCircular1(int[] A) {
        int maxSum = 0;
        int sum = 0;
        int currentSum = 0;
        for(int i=0; i < A.length; i++) {
            int c = A[i];
            sum += c;
            currentSum = Math.max( c, currentSum  + c);
            if(currentSum >  maxSum) {
                maxSum = currentSum;
            } else if(currentSum < 0) {
                currentSum = 0;
            }
        }
        return -1 * ( sum - maxSum);
    }
}