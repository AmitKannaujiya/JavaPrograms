package algoMadeEasyBook;

import java.util.Stack;

/**
 * () => 1
 * AB => A + B
 * (A) => 2 * A
 * Calculate Score of paratheses
 */
public class BalancedParathesesScore {
    public static void main(String[] args) {
        String sequence = "(()(()))";
        BalancedParathesesScore obj = new BalancedParathesesScore();
        System.out.println(obj.scoreParatheses(sequence));

    }

    private int scoreParatheses(String sequence) {
        Stack<Character> stack = new Stack<>();
        for(char ch : sequence.toCharArray()) {
            if(ch == '(') {
                stack.push(ch);
            } else if(ch == ')') {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    stack.push('1');
                } else if(!stack.isEmpty()) {
                    int stackTop = 0; 
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        stackTop += Character.getNumericValue(stack.pop());
                    }
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                        stackTop *= 2;
                    }
                    stack.push(Character.forDigit(stackTop, 10));
                }
            }
        }
        int res =0;
        while(!stack.isEmpty()) {
            res += Character.getNumericValue(stack.pop());
        }
        return res;
    }
}