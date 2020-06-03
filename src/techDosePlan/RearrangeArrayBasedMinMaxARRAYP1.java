package techDosePlan;

import java.util.Arrays;

import Utills.Utills;

public class RearrangeArrayBasedMinMaxARRAYP1 {
    public static void main(String[] args) {
        RearrangeArrayBasedMinMaxARRAYP1 obj = new RearrangeArrayBasedMinMaxARRAYP1();
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7};
        obj.rearrangeArrayBasedOnCondition(array);
        Utills.printArray(array);
        array = new int[] {1, 2, 3, 4, 5, 6,8};
        ;
        Utills.printArray(obj.rearrangeArrayBasedOnConditionV2(array, array.length));
    }

    public int[] rearrangeArrayBasedOnConditionV2(int [] array, int len) {
        int [] temp = new int[array.length];
        int evenPos = len/2;
        int oddPos = len - evenPos;
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        Arrays.sort(temp);
        int j = oddPos -1;
        for (int i = 0; i < array.length; i+=2) {
            array[i] = temp[j];
            j--;
        }
        j = oddPos;
        for (int i = 1; i < array.length; i+=2) {
            array[i] = temp[j];
            j++;
        }
        return array;

    }

    public void rearrangeArrayBasedOnCondition(int [] array) {
        int end = array.length-1;
        while(end > 0) {
            int minIndex = 0;
            int maxIndex = 0;
            for (int i = 0; i <= end; i++) {
                if(array[i] < array[minIndex]) {
                    minIndex = i;
                } else if(array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
            }
            if(end %2 == 0) {
                if(maxIndex != minIndex) {
                    if(end != maxIndex) {
                        Utills.swapArray(array, end, maxIndex);
                    }
                    if(end > 0 && (minIndex != end || minIndex != end-1)) {
                        Utills.swapArray(array, end-1, minIndex);
                    }
                }    

            } else {
                if(maxIndex != minIndex) {
                    if(end != minIndex) {
                        Utills.swapArray(array, end, minIndex);
                    }
                    if(end > 0 && (maxIndex != end || maxIndex != end-1)) {
                        Utills.swapArray(array, end-1, maxIndex);
                    }
                } 
            }
            end -= 2;
        }
    }
}