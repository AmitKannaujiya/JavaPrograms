package array;

import Utills.Utills;

/**
 * Created by amit on 12/9/18.
 */
public class FindGap {

    public static void main(String[] args) {
        int a [] = {1, 2, 5, 6, 10};
        printGap(a);

    }

    public static void printGap(int a[]) {
        int max = maxElementOfArray(a);
        int j = 0;
        for (int i = 0; i < max; i++) {
            if (a[j]==i) {
                j++;
            } else if(i > 0) {
                System.out.print(i +", ");
            }
        }
    }

    public static int maxElementOfArray(int a[]) {
        int max = Integer.MIN_VALUE;
        for (int i : a) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

}
