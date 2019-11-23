package algoMadeEasyBook;

import Utills.Utills;

public class RestElementProductArray {
    public static void main(String[] args) {
        int [] a = new int[]{6, 2, 3, 4, 5};
        Utills.printArray(productArrayExceptIDivisionOperation(a));
        System.out.println("Without Division");
        Utills.printArray(productArrayExceptI(a));
    }
    // a = {1, 2, 3, 4, 5}
//   b = {120, 60, 40, 30, 24}

    static int[] productArrayExceptIDivisionOperation(int a[]) {
        int product = 1;
        int[] b = new int[a.length];
        for(int i=0; i<a.length; i++) {
            product *= a[i];
        }
        for(int j=0; j<a.length; j++) {
            b[j] = product/a[j];
        }
        return b;
    }
// 1,  2, 6, 24 , 120
// 120, 120, 60, 20, 5

    // left = 1, 1, 2, 6, 24
// right =120,60,20 ,5 , 1
    static int[] productArrayExceptI(int a[]) {
        int[] right = new int[a.length];
        int[] left = new int[a.length];
        int[] b = new int[a.length];
        left[0] = 1;
        right[a.length-1] =1;
        for(int i=1, j=a.length-1; i<a.length; i++, j--) {
            left[i] = left[i-1] * a[i-1];
            right[j-1] = right[j]* a[j];
        }
        for(int j=0; j<a.length; j++) {
            b[j]= left[j] * right[j];
        }

        return b;
    }
}
