package stack;

import java.util.Stack;

public class MaxStack {
    int capacity;
    int top;
    int [] array;
    Stack<Integer> primaryStack;
    Stack<Integer> maxStack;

    public MaxStack(int capacity) {
        primaryStack = new Stack<>();
        maxStack =  new Stack<Integer>();

    }

    public static void main(String[] args) {

    }

    void push(int no) throws IllegalAccessException {
        primaryStack.peek();
        if(!primaryStack.isEmpty()) {
            int top = maxStack.pop();
        }
        primaryStack.push(no);
        maxStack.push(no);
    }
}
