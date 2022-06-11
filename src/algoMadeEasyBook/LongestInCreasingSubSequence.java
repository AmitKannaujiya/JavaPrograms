package algoMadeEasyBook;

public class LongestInCreasingSubSequence {
    public static void main(String[] args) {
        LongestInCreasingSubSequence obj = new LongestInCreasingSubSequence();
        int [] array = new int[]{10, 22, 9, 33, 21, 50, 0, 60};
        System.out.println(obj.longestIncreasingSubSequence(array, array.length));
    }


    public int longestIncreasingSubSequence(int [] array, int n) {
        int [] lis = new int[n+1];
        int max = 1;
        for (int i = 0; i < n + 1; i++) {
            lis[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(array[i] > array[j] && lis[i] < lis[j] +1) {
                    lis[i] = lis[j] + 1;
                    if (max  < lis[i]) {
                        max = lis[i];
                    }
                }
            }
        }
        return max;
    }
}
