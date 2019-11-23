package array;

import Utills.Utills;

public class ZeoOneSort {
    public static void main(String[] args) {
        int a[] = new int[] {1, 1, 0, 0, 1, 0, 0, 1};
        sortZeroOne(a);
        Utills.printArray(a);

    }

   static void sortZeroOne(int a[]) {
        int start = 0;
        int end= a.length-1;
        while(start < end) {
            while(a[start]==0) {
                start++;
            }
            while(a[end] == 1){
                end--;
            }
            if(start < end) {
                Utills.swapArray(a, start, end);
            }
        }
    }
}
