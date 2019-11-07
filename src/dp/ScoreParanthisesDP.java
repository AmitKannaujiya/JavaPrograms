package dp;

import java.util.Stack;

public class ScoreParanthisesDP {
    public static void main(String[] args) {
        System.out.println(scoreParenthises("(()(()))"));
        System.out.println(scoreParenthises("(()()()((())))"));
    }

    static void scoreParenthises1(String s) {
        int[] a = new int[s.length()];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int t = stack.pop();
                a[t] = i;

            } else {
                stack.push(i);
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static int scoreParenthises(String s) {
        int score = 0;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                char ch = stack.peek();
                if (ch == '(') {
                    stack.pop();
                    stack.push((char) 1);
                } else {
                    int sum = 0;
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        int no = stack.pop();
                        sum += no;
                    }
                    if (stack.peek() == '(') {
                        stack.pop();
                        sum *= 2;
                        stack.push((char) sum);
                    } else {
                        stack.push((char) sum);
                    }

                }

            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.size() == 1) {
            return stack.pop();
        }
        while (!stack.isEmpty() && stack.peek() != '(') {
            int no = stack.pop();
            score += no;
        }
        if (!stack.isEmpty() && stack.peek() == '(') {
            stack.pop();
            score *= 2;
        }
        return score;
    }
}
