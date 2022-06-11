package algoMadeEasyBook;

public class BinarySearchInPair {
    public static void main(String[] args) {
        int[] array = new int[]{11,14,17,18,20,23,27,28,29,30,45,55,59,67,61,89,90};
        int key = 32;
        BinarySearchInPair obj = new BinarySearchInPair();
        System.out.println(obj.binarySearch(array, key));
        System.out.println(obj.binarySearch(array, 41));
        System.out.println(obj.binarySearch(array, 55));
        System.out.println(obj.binarySearch(array, 915));

        System.out.println(obj.binarySearch(array, 24));
        System.out.println(obj.binarySearch(array, 60));
        System.out.println(obj.binarySearch(array, 91));

        obj.minDiffWithInPairOfArrays(new int[]{1,3,4,5,7}, new int[]{10,20,30,40,50}, 32);
    }

    public int binarySearch(int [] array, int key){
        int low = 0;
        int high = array.length -1;
        int result = array[low];
        while (low <= high) {
            int mid = low + (high - low)/2;
            if(array[mid] == key){
                return result=array[mid];
            }else if(array[mid] < key){
                result = array[mid];
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return result;
    }

    public void minDiffWithInPairOfArrays(int [] array1, int[] array2, int sum) {
        int diff = Integer.MAX_VALUE;
        int left = 0;
        int right = array2.length-1;
        int left_index = 0;
        int right_index = right;
        while (left < array1.length && right>=0) {
            if(Math.abs(array1[left]+array2[right] -sum) < diff){
                diff = Math.abs(array1[left]+array2[right]-sum);
                left_index = left;
                right_index =right;
            }
            if(array1[left] + array2[right] < sum) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("Pair of array for sum : " +sum + " array 1 :" + array1[left_index] + " array 2: " + array2[right_index]);
    }
}
