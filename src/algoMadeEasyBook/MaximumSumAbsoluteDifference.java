package algoMadeEasyBook;

import Utills.Utills;

public class MaximumSumAbsoluteDifference {

    // maximum sum absolute difference of array

    //int a[] = {1,3,2,23,9} => {1, 2, 3, 9, 23} =>  {1, 23, 2, 9, 3}=>|23-1| + |23-2| + |9 - 2| + |9-3| + |3-1|

    //{1, 2, 4, 8} => {1, 8, 2, 4} m=> |8-1| + |8-2| +|4-2| + |4-1| => 18

    //        1, 2, 4, 8 =>  8-1 + 8-2 + 4-2 + 4-1 => 18

    public static void main(String[] args) {
        System.out.println(maxDiffAbsoluteSum(new int[]{1, 2, 4, 8}));  // output : 18
        System.out.println(maxDiffAbsoluteSum(new int[]{1, 3, 2, 23, 9})); // output : 58
    }


    static int maxDiffAbsoluteSum(int a[]) {
        quicksort(a, 0, a.length - 1);
        int i = 0;
        int j = a.length - 1;
        int sum = 0;
        boolean flag = true;
        while (i < j) {
            sum += Math.abs(a[i] - a[j]);
            if (flag) {
                i++;
            } else {
                j--;
            }
            flag = !flag;
        }
        sum += Math.abs(a[0] - a[j]);
        return sum;
    }

    static void quicksort(int a[], int low, int high) {
        if (low < high) {
            int pivot = pivot(a, low, high);
            quicksort(a, low, pivot - 1);
            quicksort(a, pivot + 1, high);
        }
    }


    static int pivot(int a[], int low, int high) {
        int i = low - 1;
        int pivot = a[high];
        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                Utills.swapArray(a, i, j);
            }
        }
        Utills.swapArray(a, i + 1, high);
        return i + 1;
    }

}
