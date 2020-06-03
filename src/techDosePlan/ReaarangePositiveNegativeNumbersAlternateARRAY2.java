package techDosePlan;

import Utills.Utills;

public class ReaarangePositiveNegativeNumbersAlternateARRAY2 {
    public static void main(String[] args) {
        ReaarangePositiveNegativeNumbersAlternateARRAY2 obj = new ReaarangePositiveNegativeNumbersAlternateARRAY2();
        int[] array = new int[]{1, 2, 3, -4, -1, 4};
        //obj.rearrangeArrayToPositiveNegativealternate(array);
        //Utills.printArray(array);
        //Utills.printArray(obj.rearrangeArrayToPositiveNegativealternateV2(array));
        obj.rearrangeArrayToPositiveNegativealternateV3(array);
        Utills.printArray(array);
        int [] zeroArray = new int[] {1, 2, 0, 0, 0, 3, 6};
        obj.moveZeroToEnd2(zeroArray);
        Utills.printArray(zeroArray);
    }

    private void moveZeroToEnd(int[] array) {
        int i = -1;
        int j = array.length;
        while(i < j) {
            while(array[++i] > 0);
            while(array[--j] == 0);
            if(i < j) {
                Utills.swapArray(array, i, j);
            }
        }
    }

    private void moveZeroToEnd2(int[] array) {
        int index=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != 0) {
                Utills.swapArray(array, i, index);
                index++;
            }
        }
    }

    private int[] rearrangeArrayToPositiveNegativealternate(int [] array) {
        int pIndex = 0; int nIndex = 0;
        int index =0; 
        boolean positive = false;
        while(nIndex < array.length && pIndex < array.length ) {
            while(nIndex < array.length && array[nIndex] > 0) {
                nIndex++;
            }
            while(pIndex < array.length && array[pIndex] < 0 ) {
                pIndex++;
            }
            if(pIndex  < array.length && nIndex < array.length) {
                if(positive) {
                    Utills.swapArray(array, index, pIndex);
                } else {
                    Utills.swapArray(array, index, nIndex);
                }
                index++;
                positive = !positive;
            }

        }
        while(pIndex < array.length && index < array.length) {
            array[index++] = array[pIndex++];
        }
        while(nIndex < array.length && index < array.length ) {
            array[index++] = array[nIndex++];
        }
        return array;
    }

    private int[] rearrangeArrayToPositiveNegativealternateV2(int [] array) {
        int pIndex = 0; int nIndex = 0;
        int index =0; 
        boolean positive = false;
        int [] temp = new int[array.length];
        while(nIndex < array.length && pIndex < array.length ) {
            while(nIndex < array.length && array[nIndex] > 0) {
                nIndex++;
            }
            while(pIndex < array.length && array[pIndex] < 0 ) {
                pIndex++;
            }
            if(pIndex  < array.length && nIndex < array.length) {
                if(positive) {
                    temp[index] = array[pIndex];
                    Utills.swapArray(array, index, pIndex);
                } else {
                    temp[index] = array[nIndex];
                    Utills.swapArray(array, index, nIndex);
                }
                index++;
                positive = !positive;
            }

        }
        while(pIndex < array.length && index < array.length) {
            temp[index++] = array[pIndex++];
        }
        while(nIndex < array.length && index < array.length ) {
            temp[index++] = array[nIndex++];
        }
        return temp;
    }

    public void rearrangeArrayToPositiveNegativealternateV3(int[] array) {
        int start = -1;
        int end = array.length;
        while(start < end) {
            while(array[++start] > 0);
            while(array[--end] < 0);
            if(start < end) {
                Utills.swapArray(array, start, end);
            }
        }
        if(start == 0 || start == array.length) {
            return;
        }

        int k =0;
        while(k < array.length && start < array.length) {
            Utills.swapArray(array, start, k);
            start++;
            k +=2;
        }
    }
}