package array;

import Utills.Utills;

/**
 * Created by amit on 15/7/18.
 */
public class QuickSort {
    public static void main(String[] args) {
        int a[]={1, 4, 45, 6, 10, -8, 7};
        int sum = 16;
        QuickSort quickSort = new QuickSort();
        quickSort.quicksort(a, 0, a.length-1);
        for (int p : a) {
            System.out.println(p);
        }

    }

    void quicksort(int a[], int start, int end) {
        System.out.println("start "+start +" end "+end);
        if(start < end) {
            int partion = partion(a, start, end);
            quicksort(a, start, partion - 1);
            quicksort(a, partion + 1, end);
        }
    }

    int partion(int a[], int si, int ei) {
        int x= a[ei];
        int i = si -1;
        int j;
        for (j = si; j< ei; j++) {
            if(a[j] <= x) {
                i++;
                Utills.swapArray(a, i, j);
            }
        }
        Utills.swapArray(a, i+1, ei);
        return  i+1;

    }



}
