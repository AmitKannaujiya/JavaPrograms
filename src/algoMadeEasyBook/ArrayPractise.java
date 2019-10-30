package algoMadeEasyBook;

import Utills.Utills;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ArrayPractise {
    public static void main(String[] args) {
        System.out.println("Junps : " + noOfJumps(new int[]{3, 4, 1, 2, 5, 6, 9, 0, 1, 2, 3, 1}));

        System.out.println("Sun of digits :" + sumOfDigits(1325132435356l));
        System.out.println("10 power less than no :" + 999 + " =>"+ getNearest10Power(999l));
        System.out.println("10 power less than no :" + 1 + " =>"+ getNearest10Power(1l));
        System.out.println("10 power less than no :" + 45 + " =>"+ getNearest10Power(45l));
        System.out.println("10 power less than no :" + 45678 + " =>"+ getNearest10Power(45678l));

        System.out.println(nummaricalPalindrom(100001l));
        System.out.println(nummaricalPalindrom(4224l));
        System.out.println(nummaricalPalindrom(123456654321l));

        int array[]=new int[]{3, 4, 1, 2, 5, 6, 9, 0, 1, 2, 3, 1};
        prefixSort(array);
        Utills.printArray(array);


        nextSmallerNo(new int[] {4, 8, 5, 2, 25});

        twoSum1(new int[]{2,7,11,15}, 9);
    }

    /**
     * Constraints: 1) Is length of array is infinite ?
     *              2) Does array contains negative nos ?
     *  Idea :      Efficient: scan array and at each no, check length of array is lies outside of the size of array,
     *              IF it is the case than return jumps else increment the jumps
     *
     * @param a
     * @return
     */
    private static int noOfJumps(int a[]){
        int length = a.length;
        int jumps =0;
        int j=0;
        while(j < length) {
            j = j + a[j];
            if(j==0) {
                return 0;
            }
            jumps++;
        }
        return jumps;
    }

    /***
     * constrains : 1) what is the range of inputs , what will be max/min value ?
     *
     * @param num
     * @return
     */
    private static int sumOfDigits(long num) {
        num = Math.abs(num);
        int sum = 0;
        while (num > 0 ) {
            sum += num%10;
            num /=10;
        }

        return sum;
    }

    private static boolean nummaricalPalindrom(long num) {
        if(num < 10) {
            return true;
        }
        long nearest10 = getNearest10Power(num);
        long d = 10;
        long n1 =1, n2 =1;
        long numLeft = num,numRight = num;
        while (n1 == n2) {
            n1 =  numLeft/nearest10;
            nearest10 /=10;
            numLeft /= nearest10;
            n2 = numRight%d;
            numRight /= 10;

            d *=10;
        }
        return n1 == n2;
    }

    private static long getNearest10Power(long num) {
        if(num < 10) {
            return 0;
        }
        long divider = 10;
        while (num > divider && divider * 10 <=num) {
            divider *=10;
        }
        return divider;
    }

    private static boolean is1_0_EditAway(String first, String second){
        if(first ==null || second ==null) {
            return false;
        }
        if(first.length() == second.length()) {
            return checkReplace(first, second);
        } else if(first.length() == second.length()+1) {
            return checkInsert(first, second);
        } else if(first.length()  == second.length() -1) {
            return checkDelete(first, second);
        }
        return false;
    }

    private static boolean checkDelete(String first, String second) {
        int findex = 0;
        int count =0;
        while(first.length() > findex ) {
            if(first.charAt(findex)!= second.charAt(findex + count)){
                count++;
            }
            findex++;
        }
        return findex + count <= first.length();
    }

    private static boolean checkInsert(String first, String second) {
        return false;
    }

    private static boolean checkReplace(String first, String second) {
        return false;
    }

    /**
     * Prefix sort will sort based on reversing input array, storing higher element on the end
     *
     * @param a
     */

    private static void  prefixSort(int a[]) {int k=a.length-1;

        for (int i = 0; i < a.length; i++) {

        int max=a[0];int index=0;
            for (int j = 1; j <= k ; j++) {
                if(max < a[j]) {
                    max=a[j];
                    index=j;
                }
            }
            reverseArray(a, 0, index);
            reverseArray(a, 0, k);k--;
        }
    }

    private static void reverseArray(int a[], int start, int end) {

        int b[] = new int[end+1];
        for (int i = 0; i <= end-start; i++) {
            b[i]= a[start+i];
        }
        for (int i = start,k=0; i <=end ; i++ , k++) {
            a[end-k]= b[i];
        }
    }

    private static void nextSmallerNo(int a[]) {
        Stack<Integer> stack =new Stack<>();
        if(a.length > 1) {
            stack.push(a[0]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        while(!stack.isEmpty()) {

            for (int i = 1; i < a.length ; i++) {
                if(stack.isEmpty()) {
                    stack.push(a[i]);
                    continue;
                }
                while (stack.isEmpty() == false && stack.peek() > a[i]) {
                    System.out.println(stack.peek() + " -> " + a[i]);
                    map.put(stack.peek(), a[i] );
                    stack.pop();
                }
                stack.push(a[i]);
            }

            while(!stack.isEmpty()) {
                System.out.println(stack.peek() + " -> "+ -1);
                map.put(stack.peek(), -1);
                stack.pop();
            }
        }
        System.out.println("Reaordering");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " -> " + map.get(a[i]));
        }
    }

    public int[] twoSum(int[] nums, int target) {
        if(nums.length== 2) {
            return new int[]{0,1};
        }
       // int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target -nums[i])) {
                int index = map.get(target-nums[i]);
                return new int[] {index, i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    static public int[] twoSum1(int[] nums, int target) {
        if(nums.length== 2) {
            return new int[]{0,1};
        }
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if(max < nums[i] ) {
                max = nums[i];
            }
        }
        int indexs [] =new int[max+1];
        for (int i = 0; i < max+1; i++) {
            indexs[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if(indexs[target - nums[i]] > -1 ) {
                return new int[] {indexs[target - nums[i]], i};
            }
            indexs[nums[i]] = i;
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int no = map.get(nums[i]);
                map.put(nums[i], no+1);
            }
            for (int j = 0; j < nums.length; j++) {
                int target  = -1 * nums[j];
                for (int k = 0; k <nums.length; k++) {

                }
            }
        }
        return null;
    }
}
