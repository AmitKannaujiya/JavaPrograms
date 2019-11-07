package array;

public class SubArraySum {

//    Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
//    Ouptut: Sum found between indexes 2 and 4

    public static void main(String[] args) {
        int[] arr = {1, 4, 20, 3, 10, 5};
        int n = arr.length;
        int sum = 33;
        subArraySum1(arr, n, sum);
    }

    private static void subArraySum1(int[] arr, int n, int sum) {
        int currentSum = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];

            while (currentSum > sum && start <= i) {
                currentSum -= arr[start++];
            }
            if (currentSum == sum) {
                System.out.println("at index i :" + i);
                return;
            }


        }
    }
}
