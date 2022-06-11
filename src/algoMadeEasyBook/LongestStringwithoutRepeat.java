package algoMadeEasyBook;

import java.util.HashMap;
import java.util.HashSet;

public class LongestStringwithoutRepeat {
    public static void main(String[] args) {
        LongestStringwithoutRepeat obj =new LongestStringwithoutRepeat();
        System.out.println(obj.lengthOfLongestSubstring("abccbadb"));
        System.out.println(obj.lengthOfLongestSubstring("abccbadb"));
        System.out.println(obj.lengthOfLongestSubstring("abccbab"));
        System.out.println(obj.lengthOfLongestSubstring("abc"));
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));

        //System.out.println(obj.lengthOfLongestSubstring_optimize("pwwkew"));
        System.out.println(obj.lengthOfLongestSubstring_optimize("abcbdaca"));
    }
    public int lengthOfLongestSubstring_optimize(String s) {
        int i =0;
        int j =0;
        int max =0;
        HashMap<Character,Integer> map =new HashMap<>();
        while(j < s.length()) {
            char ch = s.charAt(j);
            if(map.containsKey(ch)) {
                int index = map.get(ch);
                if(i <= index) {
                    i = index + 1;
                }
            }
            int k = j-i +1;
            max = Math.max(k,max);
            map.put(ch, j);
            j++;
        }
        return max;
    }
    public int lengthOfLongestSubstring(String s) {
        int i =0;
        int j =0;
        HashSet<Character> set =new HashSet<>();
        int max =0;
        while(j < s.length()) {
            char ch = s.charAt(j);
            if(set.contains(ch)) {
                while(i < j) {
                    set.remove(s.charAt(i));
                    if(ch == s.charAt(i)) {
                        i++;
                        break;
                    }
                    i++;
                }
            }
            int k = j-i +1;
            max = Math.max(k,max);
            set.add(ch);
            j++;
        }
        return max;
    }
}
