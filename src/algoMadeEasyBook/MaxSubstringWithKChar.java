package algoMadeEasyBook;

import java.util.HashSet;

public class MaxSubstringWithKChar {
    public static void main(String[] args) {
        MaxSubstringWithKChar  obj = new MaxSubstringWithKChar();
        obj.substringWithUniqueK("aabbcc",1);
        obj.substringWithUniqueK("aabbcc",2);
        obj.substringWithUniqueK("aabbcc",3);
        obj.substringWithUniqueK("aabbcc",4);
        //obj.substringWithUniqueK_count("aabacbebebeb",3);
        //obj.substringWithUniqueK_count("aabacbebebeb",5);
        obj.substringWithUniqueK_count("",1);
        //obj.substringWithUniqueK_count("aabbcc",1);
        //obj.substringWithUniqueK_count("aabbcc",2);
        obj.substringWithUniqueK_count("aabbcc",3);
        //obj.substringWithUniqueK_count("aabbcc",4);
    }

    public void substringWithUniqueK_count(String str, int k) {
        if(str == null || str.length() == 0 ){
            System.out.println("No  solution");
            return;
        }
        int max = Integer.MIN_VALUE;
        int uniqCount = 0;
        for (int i = 0; i <str.length(); i++) {
            if (str.charAt(i) - 'a' > max)  {
                max = str.charAt(i) - 'a';
                uniqCount++;
            }
        }
        if(uniqCount < k) {
            System.out.println("No  solution");
            return;
        }

        int[] count = new int[max+1];
        count[str.charAt(0) - 'a']++;
        int start = 0;
        int end = 0;
        int maxLen = 1;
        int maxStart = 0;

        for(int i = 1; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
            end = i;
            while (!isMaxElementAvailable(count, k) && start < str.length()) {
                count[str.charAt(start)- 'a']--;
                start++;
            }
            if(end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                maxStart = start;
            }
        }
        System.out.println("Max substring : " +str.substring(maxStart, maxStart + maxLen));
    }

    public boolean isMaxElementAvailable(int[] count,int k) {
        int val= 0;
        for (int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                val++;
            }
        }
        return k >= val;
    }

    public void substringWithUniqueK(String str, int k) {
        HashSet<Character> set = new HashSet<>();
        String output = "";
        int j = 0;
        while (j < str.length() && set.size() <=k) {
            char ch = str.charAt(j);
            if(!set.contains(ch)) {
                set.add(ch);
            }
            j++;
        }
        if(set.size()==k+1) {
            output =str.substring(0, j -1);
        } else if(set.size()==k) {
            output =str.substring(0, j);
        }
        System.out.println("Answer : " + output);
    }

    public void substringCount(String str, int k) {

        int j = 1;
        int count = 1;
        String output = "";
        while (j< str.length() && count < k) {
            if(str.charAt(j-1) == str.charAt(j) && count < k) {
                j++;
            } else if (str.charAt(j-1) != str.charAt(j) && count < k) {
                count++;
                j++;
            } else {
                break;
            }
        }
        if(count == k){
            output = str.substring(0, j);
        }

        System.out.println("Answer : " + output);
    }
}
