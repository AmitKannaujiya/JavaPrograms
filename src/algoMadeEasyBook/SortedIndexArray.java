package algoMadeEasyBook;


import java.util.Stack;

public class SortedIndexArray {
    public static void main(String[] args) {
        int [] array = new int[]{10, 12, 20, 30, 25, 40,55, 22, 19, 32, 31, 35, 50, 60};
        SortedIndexArray obj = new SortedIndexArray();
        obj.getSortedIndex(array);
        obj.getSortedIndex_next(array);
        
    }
    
    public void getSortedIndex(int[] array) {
        int start = 0;
        int end = array.length-1;
        int[] nse = new int[array.length];
        Stack<Integer> stack =new Stack<>();
        for (int i = array.length-1; i >=0; i--) {
            while (!stack.isEmpty() && stack.peek() > array[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(array[i]);
        }
        Stack<Integer> stack1 =new Stack<>();
        int[] nge = new int[array.length];
        for (int i = array.length-1; i >=0; i--) {
            while (!stack1.isEmpty() && stack1.peek() < array[i]) {
                stack1.pop();
            }
            nge[i] = stack1.isEmpty() ? -1 : stack1.peek();
            stack1.push(array[i]);
        }
        for (int i = 0; i < nse.length; i++) {
            if(nse[i] != -1) {
                start = i;
                break;
            }
        }
        for (int i = nge.length-1; i >=0; i--) {
            if(nge[i] != -1) {
                end = i;
                break;
            }
        }

        System.out.println(" strat : " + array[start] + " end : " +array[end]);

    }
    public void getSortedIndex_next(int[] array) {
        int start =0;
        int end =  array.length-1;
        while (start < array.length && array[start+1]>= array[start]) {
            start++;
        }
        if(start == array.length) {
            System.out.println("Array is sorted");
            return;
        }
        while (end >= 0 && array[end] >= array[end-1]) {
            end--;
        }

        int min =Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end ; i++) {
            if(array[i] <  min) {
                min=array[i];
            }
        }
        for (int i = start; i <= end ; i++) {
            if(array[i] >  max) {
                max=array[i];
            }
        }
        for (int i = end; i<array.length-1;i++) {
            if(array[i] > max) {
                break;
            }
            end = i;
        }
        for (int i = start; i>=0;i--) {
            if(array[i] < min) {
                break;
            }
            start = i;
        }
        System.out.println(" start : " + array[start] + " end : " +array[end]);
    }

}
