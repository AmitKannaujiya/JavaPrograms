package array;

import Utills.Utills;

/**
 * Created by amit on 14/7/18.
 */
public class SumOf2EqualsX {
//    Writea C programthat, given an arrayA[] of n numbersand another number x, determines whether or not thereexist two elements in S whose
//    sumisexactly x.

    public static void main(String[] args) {
        int a[] = {1, 4, 45, 6, 10, -8};
        int sum = 16;
        SumOf2EqualsX obj = new SumOf2EqualsX();
        obj.SumOf2EqualToX(a, sum);

    }

    private void SumOf2EqualToX(int[] a, int sum) {
        int maxElm = Utills.maxElementOfArray(a);
        boolean[] b = new boolean[maxElm + 1];
        for (int i : a) {
            b[i] = true;
        }

        for (int i : a) {
            if (sum - i > 0 && b[sum - i]) {
                System.out.printf(" two nos are %d %d", i, sum - i);
                return;
            }
        }
        System.out.println("No such two elements exists");
    }
}
