package algoMadeEasyBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HackerRankEpifiProblem {

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
//        String[] strs = line.trim().split("\\s+");

        //String expression = "[|, [&, 1, [!, 0]], [!, [|, [|, 1, 0], [!, 1]]]]";
        String expression = "[&, 0, [!, 1], [&, 0, 0, 1, 0]]";
        System.out.println(evaluateExpression(expression));
    }


    private static int evaluateExpression1(String exp) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i< exp.length(); i++) {
            char ch = exp.charAt(i);
            if(isValid(ch)) {
                if(ch == ']') {
                    char op1 = '@';
                    char op2 = '@';
                    char operation = '@';
                    List<Character> operands = new ArrayList<>();
                    while (!stack.isEmpty() && stack.peek() != '[') {
                        if(op1 == '@') {
                            op1 = stack.pop();
                        } else if(operation(stack.peek())) {
                            operation = stack.pop();
                        } else {
                            op2 = stack.pop();
                        }
                    }
                    stack.pop();
                    char result = execute(op1, op2, operation);
                    stack.push(result);
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.peek() == '1' ? 1 : 0;
    }

    private static int evaluateExpression(String exp) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i< exp.length(); i++) {
            char ch = exp.charAt(i);
            if(isValid(ch)) {
                if(ch == ']') {
                    char op1 = '@';
                    char op2 = '@';
                    char operation = '@';
                    List<Character> operands = new ArrayList<>();
                    while (!stack.isEmpty() && stack.peek() != '[') {
                        if(op1 == '@') {
                            op1 = stack.pop();
                        } else if(operation(stack.peek())) {
                            operation = stack.pop();
                        } else {
                            op2 = stack.pop();
                        }
                    }
                    stack.pop();
                    char result = execute(op1, op2, operation);
                    stack.push(result);
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.peek() == '1' ? 1 : 0;
    }

    private static char execute(char op1,  char op2, char operation) {
        if(operation == '!') {
            return op1 == '1' ? '0' : '1';
        } else if (operation == '&') {
            int res = (int)op1 & (int) op2;
            return (char) res;
        } else {
            int res = (int)op1 | (int) op2;
            return (char) res;
        }
    }

    private static boolean operation(char op) {
        if(op == '!' || op == '|' || op == '&') {
            return true;
        }
        return false;
    }


    private static boolean isValid(char ch) {
        if(ch == ' ' || ch == ',') {
            return false;
        }
        return true;
    }

    
}
