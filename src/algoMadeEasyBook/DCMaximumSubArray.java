package algoMadeEasyBook;

public class DCMaximumSubArray {
    public static void main(String[] args) {
        int[] array = new int[]{-2, -5, 6, -2, -3, 1, 5, -6};
        DCMaximumSubArray obj = new DCMaximumSubArray();
        System.out.println(obj.maximumSumSubArray(array, 0, array.length-1));

        int[] arr1 = new int[]{34, -50, 42, 14, -5, 86};
        System.out.println(obj.maximumSumSubArray(arr1, 0, arr1.length-1));

    }

    public int maximumSumSubArray(int[] array, int low, int high) {
        if(low == high) {
            return array[low];
        }

            int mid = low + (high - low)/2;
            return Math.max(Math.max(maximumSumSubArray(array, low,mid), maximumSumSubArray(array, low+1,high)),
                 collectMaxSubArraySum(array, low, mid, high));

    }

    public int collectMaxSubArraySum(int[] array, int low, int mid, int high){
        int sum =0;
        int max = Integer.MIN_VALUE;
        for (int i = mid; i >=low ; i--) {
            sum += array[i];
            if(max < sum){
                max = sum;
            }
        }
        sum = 0;
        int maxH = Integer.MIN_VALUE;
        for (int i = mid+1; i <=high ; i++) {
            sum += array[i];
            if (maxH < sum) {
                maxH = sum;
            }
        }
        return Math.max(maxH + max, Math.max(max, maxH));
    }
}
