package array;

import Utills.Utills;

public class MergeArrayGFG {

    public static void main(String[] args) {
        int array1[] = {2 , -1, 7, -1,-1,10,-1};
        int array2[] = {5,8,12,14};
        MergeArrayGFG obj = new MergeArrayGFG();
        obj.mergeArray(array1, array2);
        Utills.printArray(array1);

    }

    int[] mergeArray(int[] first, int[] second) {
        int i=0;
        int j = 0;
        int current=0;
        int last= first.length-1;
        int index = first.length-1;
        while(last>=0 ) {
            while(first[last] == -1) {
                last--;
            }
            int temp = first[index];
            first[index] = first[last];
            first[last] = temp;
            index--;
            last--;
        }
        int right = index;
        while(j<second.length) {

            if(first[index] < second[j]) {
                first[current++] = first[index++];
            } else {
                first[current++] = second[j++];
            }
            //current++;
        }
//        while (j < second.length && current < first.length) {
//            first[current++] = second[j++];
//        }
        return first;
    }

    int[] mergerArray(int[] first, int[] second) {
        int i =0;
        int j = 0;
        int current = 0;
        int right = first.length - 1;
        int index = first.length -1;
        while (right >= 0) {
            while (first[right] == -1) {
                right--;
            }
            if(right != index) {
                Utills.swapArray(first, right, index);
            }
        }
        return first;
    }



}
