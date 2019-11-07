package array;

/**
 * Created by amit on 17/3/19.
 */
public class LongestIncreasingSubSequenceAlgoBook {


    public static void main(String[] args) {
        int a[] = {-3, 2, 1, -5, 6, 0, 2 - 7, 12, 2, 3};

        LongestIncreasingSubSequenceAlgoBook obj = new LongestIncreasingSubSequenceAlgoBook();
        System.out.println(obj.longestIncreasingSubSequence(a));
        System.out.println(obj.longestIncreasingSubSequenceV2(a));
        System.out.println(obj.longestIncreasingSubSequenceV3(a));
    }

    public int longestIncreasingSubSequence(int a[]) {
        int maxSumSoFar = 0;
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            maxSumSoFar += a[i];

            if (maxSum < maxSumSoFar) {
                maxSum = maxSumSoFar;
            }

            if (maxSumSoFar < 0) {
                maxSumSoFar = 0;
            }
        }
        return maxSum;
    }

    public int longestIncreasingSubSequenceV2(int a[]) {
        int maxSumSoFar = 0;
        int maxSum = 0;
        int si = 0, ei = 0, st = 0;
        for (int i = 0; i < a.length; i++) {
            maxSumSoFar += a[i];
            if (maxSumSoFar < 0) {
                maxSumSoFar = 0;
                st = i + 1;
            } else if (maxSum < maxSumSoFar) {
                maxSum = maxSumSoFar;
                si = st;
                ei = i;
            }

        }
        System.out.println(" Start : " + si + " end " + ei);
        return maxSum;
    }

    public int longestIncreasingSubSequenceV3(int a[]) {
        int currentMax = a[0];
        int maxSum = a[0];
        for (int i = 1; i < a.length; i++) {
            currentMax = Math.max(a[i], currentMax + a[i]);
            maxSum = Math.max(currentMax, maxSum);
        }
        return maxSum;
    }
}
