package algoMadeEasyBook;


import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        NextGreaterElement obj = new NextGreaterElement();
        int[] array = new int[]{11, 13, 21, 3, 4, 2};
        obj.nextGreaterElement(array);
        System.out.println("--------");
        obj.nextGreaterElement(new int[]{8, 5, 2, 3, 9});
        System.out.println("-------");
        obj.nextGreaterElement(new int[]{18, 25, 2, 13, 29});
    }

    public void nextGreaterElement(int[] array){
        Stack<Integer>  stack =new Stack<>();
        stack.push(array[0]);
        for (int i = 1; i < array.length; i++) {
            if(stack.empty()) {
                stack.push(array[i]);
                continue;
            }
            while (!stack.empty() && array[i] > stack.peek()) {
                System.out.println("element " + stack.peek() + " --> " + array[i]);
                stack.pop();
            }
            stack.push(array[i]);
        }
        while (!stack.isEmpty()) {
            System.out.println("element " + stack.peek() + " --> -1");
            stack.pop();
        }
    }
}
