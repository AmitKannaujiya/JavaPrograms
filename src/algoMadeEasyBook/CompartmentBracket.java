package algoMadeEasyBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CompartmentBracket {
    public static void main(String[] args) {
        String s = "*|**|***|*****|*****";
        int[] start= new int[]{1, 5, 1, 1, 9};
        int[] end= new int[]  {1, 9, 8, 9, 15};

        CompartmentBracket  obj = new CompartmentBracket();
        System.out.println(obj.getMaxStartsOnEachBrackets(s, start, end));
    }

    public List<Integer> getMaxStartsOnEachBrackets(String str, int[] start,int[] end) {
        List<Integer> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        int total = 0;
        int[] count =new int[str.length()];
        for (int i =0; i< str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '|') {
                while (!stack.isEmpty()) {
                    if(stack.peek() == '*'){
                        total++;
                    }
                    stack.pop();
                }
                stack.push(ch);
            } else if(ch == '*' && stack.size() > 0){
                stack.push(ch);
            }
            count[i] = total;
        }
        for (int i = 0; i < start.length; i++) {
            int s = start[i] -1;
            int e = end[i] -1;
            result.add(count[e] - count[s]);
        }
        return result;
    }
}
