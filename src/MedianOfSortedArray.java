import Utills.Utills;

public class MedianOfSortedArray {
    public static void main(String[] args) {
        int [] firstArray = new int[]{1,3,5,7};
        int [] secondArray = new int[]{2,4,6,8};
        System.out.println(medianOfSortedArray(firstArray, secondArray));

        System.out.println(medianOfSortedArray(new int[]{1,3,5}, new int[]{2,4,6}));

        System.out.println(medianOfSortedArray2(firstArray, secondArray));

        System.out.println(medianOfSortedArray2(new int[]{1,3,5}, new int[]{2,4,6}));
    }

//    static float medianOfSortedArray(int[] firstArray, int[] secondArray) {
//        int fLen = firstArray.length;
//        int sLen = secondArray.length;
//        int firstMedian = fLen %2== 0 ?((fLen+fLen-1)/2) : fLen/2;
//        int secondMedian = sLen %2== 0 ?((sLen+sLen-1)/2) : sLen/2;
//        return (float)(firstArray[firstMedian] + secondArray[secondMedian] )/2;
//    }

    static float medianOfSortedArray(int[] firstArray, int[] secondArray) {
        int fLen = firstArray.length;
        int sLen = secondArray.length;
        float firstMedian, secondMedian;
        if(fLen %2 == 0) {
            firstMedian = (firstArray[fLen/2] + firstArray[(fLen-1)/2])/2;
        } else {
            firstMedian = (firstArray[fLen/2] +1)/2;
        }

        if(sLen %2 == 0) {
            secondMedian = (secondArray[fLen/2] + secondArray[(fLen-1)/2])/2;
        } else {
            secondMedian = (secondArray[fLen/2] +1)/2;
        }
        return (float)(firstMedian + secondMedian)/2;
    }


    static double medianOfSortedArray2(int[] firstArray, int[] secondArray) {
        int fLen = firstArray.length;
        int sLen = secondArray.length;
        int total = fLen + sLen;
        int thirdArray [] = new int[total];
        int i =0, j=0,k=0;
        while (i<fLen && j<sLen) {
            if(firstArray[i] < secondArray[j]) {
                thirdArray[k++] = firstArray[i++];
            } else if(firstArray[i] > secondArray[j]) {
                thirdArray[k++] = secondArray[j++];
            } else {
                thirdArray[k++] = firstArray[i++];
                j++;
            }
        }
        while(i< fLen) {
            thirdArray[k++] = firstArray[i++];
        }
        while (j< sLen) {
            thirdArray[k++]=secondArray[j++];
        }
        return Utills.getMedian(thirdArray);
    }
}