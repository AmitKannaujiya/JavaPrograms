package algoMadeEasyBook;

import java.util.Stack;

public class RemoveMinBracketsValidParanthesis {
    class BracketIndex {
        char ch;
        int index;
        BracketIndex(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        RemoveMinBracketsValidParanthesis obj = new RemoveMinBracketsValidParanthesis();
        System.out.println(obj.removeMinBracketsToSolve("(abc(d)"));
        System.out.println(obj.removeMinBracketsToSolve("a)bc(d)"));
        System.out.println(obj.removeMinBracketsToSolve("abcd))"));
        System.out.println(obj.removeMinBracketsToSolve("((abcd))"));

        System.out.println(obj.removeMinBracketsToSolve("abcd)"));
        System.out.println(obj.removeMinBracketsToSolve("ab(cd"));

        System.out.println(obj.removeMinBracketsToSolve("a(b((cd)"));
        System.out.println("outut " + obj.removeMinBracketsToSolve("))(("));
    }



    public String removeMinBracketsToSolve(String str) {
        Stack<BracketIndex> stack = new Stack<>();
        for (int i=0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                stack.push(new BracketIndex(ch, i));
            } else if(ch == ')'){
                if(!stack.isEmpty() && stack.peek().ch == '(') {
                    stack.pop();
                } else {
                    stack.push(new BracketIndex(ch, i));
                }
            }
        }
        String result = str;
        while (!stack.isEmpty()) {
            BracketIndex bracketIndex =stack.pop();
            if(bracketIndex.index ==0){
                result = result.substring(1);
            } else {
                result = result.substring(0, bracketIndex.index) + result.substring(bracketIndex.index+1);
            }
        }
        return result;
    }

}
