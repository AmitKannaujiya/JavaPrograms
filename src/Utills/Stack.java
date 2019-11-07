package Utills;

import java.util.ArrayList;

/**
 * Created by amit on 22/7/18.
 */
public class Stack<T> {
    int TOP = -1;
    ArrayList<T> stack = new ArrayList<>();

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(T t) {
        stack.add(++TOP, t);
    }

    public T pop() throws IllegalAccessException {
        if (isEmpty()) {
            System.out.print(" stack is empty ");
            //throw new IllegalAccessException("Can't pop from empty Stack");
        }
        return stack.remove(TOP--);
    }

}
