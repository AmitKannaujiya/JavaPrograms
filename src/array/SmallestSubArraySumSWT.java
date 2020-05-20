package array;

public class SmallestSubArraySumSWT {
    public static void main(String[] args) {
        SmallestSubArraySumSWT obj = new SmallestSubArraySumSWT();
        int[] array = new int[] {4,2,2,7,8,1,2,8,1,0};
        int target = 8;
        System.out.println(obj.getSmalestWindowGreaterThanEqaulSum(array, target));
    }

    private int getSmalestWindowGreaterThanEqaulSum(int [] array, int target) {
        int start = 0;
        int minWindowSize = array.length;
        int currentSum = 0;
        for(int i=0; i < array.length; i++) {
            currentSum += array[i];
            while(currentSum >= target) {
                minWindowSize = Math.min(minWindowSize, i-start + 1);
                currentSum -= array[start++];
            }
            if(minWindowSize == 1) {
                break;
            }
        }
        return minWindowSize;
    }
}