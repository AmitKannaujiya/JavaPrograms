package algoMadeEasyBook;

import Utills.Stack;

public class RemoveallOccuranceOfPatternInString {
    public static void main(String[] args) {
        String str = "abaabcbcabcc";
        String pat = "abc";
        RemoveallOccuranceOfPatternInString obj = new RemoveallOccuranceOfPatternInString();
        System.out.println(obj.removeAllOccrances(str, pat));
    }

    private String removeAllOccrances(String str, String pat) {
        Stack<Character> stack = new Stack<>();
        boolean found =false;
        int oldLen = str.length();
        do {
            for(int i=0; i < str.length(); i++) {
                int j=0;
                int count = 0;
                while(j < pat.length() && str.charAt(i+j) == pat.charAt(j)) {
                    count++;
                    j++;
                }
                if(count ==  pat.length()) {
                    str = str.substring(0, i) + str.substring(i + count);
                }
            }
            found = oldLen > str.length();
            oldLen = str.length();
        } while(found);
        return str;
    }
}

