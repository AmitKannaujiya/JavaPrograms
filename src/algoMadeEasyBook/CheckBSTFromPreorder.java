package algoMadeEasyBook;

import java.util.Stack;

public class CheckBSTFromPreorder {
    public static void main(String[] args) {
        CheckBSTFromPreorder bst = new CheckBSTFromPreorder();
        int[] input = new int[] {2, 4, 3};
        System.out.println(bst.checkBSTFromPreorder(input, 0, input.length));
        System.out.println(bst.checkBSTFromPreorderStack1(input));
        input = new int[]{2,4,1};
        System.out.println(bst.checkBSTFromPreorder(input, 0, input.length));
        input = new int[]{4,3,2,1,5,6,7};
        System.out.println(bst.checkBSTFromPreorder(input, 0, input.length));
        input = new int[]{40,30,25,35,50,48,65};
        System.out.println(bst.checkBSTFromPreorder(input, 0, input.length));

        input = new int[]{25,15,12,20,18,30,28,26,40};
        System.out.println(bst.checkBSTFromPreorderStack1(input));
    }

    private boolean checkBSTFromPreorder(int[] input, int start, int end) {
        if(start >=  end) {
            return true;
        }
        int root = input[start];
        int j = start +1 ;
        while (j < end) {
            if(input[j] > root) {
                break;
            }
            j++;
        }
        int k = j;
        while (k < end) {
            if(input[k] < root) {
                return false;
            }
            k++;
        }

        return  checkBSTFromPreorder(input, start+1, j) && checkBSTFromPreorder(input, j+1, end);
    }
/// 40,30,25,35,50,48,65
    private boolean checkBSTFromPreorderStack1(int[] input) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            if(root > input[i]) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() < input[i]) {
                root = stack.pop();
            }
            stack.push(input[i]);
        }
        return true;
    }

    private boolean checkBSTFromPreorderStack(int[] input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MIN_VALUE);
        for (int i = 0; i < input.length; i++) {

            while (!stack.isEmpty() && stack.peek() < input[i]) {
                stack.pop();
            }
            stack.push(input[i]);
        }
        if(stack.size() > 1) {
            return false;
        }
        return true;
    }
}
