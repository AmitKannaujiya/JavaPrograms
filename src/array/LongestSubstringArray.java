package array;
import java.util.*;
import java.lang.String;
import java.lang.Character;
import java.lang.Integer;
import java.util.HashSet;

public class LongestSubstringArray {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(new String("abcabcbb")));
        System.out.println(lengthOfLongestSubstring(new String("bbbbb")));
        System.out.println(lengthOfLongestSubstring(new String("pwwkew")));
        System.out.println(lengthOfLongestSubstring(new String("dvdf")));
        System.out.println(consicutiveNumber(new int[]{4, 2, 1, 5, 6}));
        System.out.println(consicutiveNumber(new int[]{ 5, 1, 4, 8}));

        System.out.println(lengthOfLongestSubstring2(new String("pwwkew")));
    }

    static int lengthOfLongestSubstring2(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int j=0, i=0;

        while(i< s.length() && j< s.length()) {
            char ch = s.charAt(j);
            if(!set.contains(ch)) {
                set.add(ch);
                j++;
                maxLength = Math.max(maxLength, set.size());
            } else {
                set.remove(s.charAt(i));
                i++;
            }

        }
        return Math.max(maxLength, set.size());

    }

    static int consicutiveNumber(int a[]) {
        if(a.length<=1) {
            return a.length;
        }
        SortedMap<Integer, Integer> map =  new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], i);
        }
        int length = 0;
        int lastValue = 0;
        int lastIndex = 0;
        int maxLength=0;
        for (Map.Entry<Integer, Integer> next : map.entrySet()) {
            if(next.getKey()== lastValue+1 && next.getValue() >= lastIndex) {
                length++;
            } else {
                maxLength = Math.max(maxLength, length);
                length = 1;
            }
            lastValue = next.getKey();
            lastIndex = next.getValue();
        }
        return Math.max(maxLength, length);
    }

    static int lengthOfLongestSubstring1(String s) {
        if(s.length()<=1) {
            return s.length();
        }
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char startChar = s.charAt(i);
            for (int j = 1; j < s.length() ; j++) {

            }
        }
        return maxLength;
    }

    static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> characterFrequency = new LinkedHashMap<>();
        int maxLength = -1;
        int currentLength = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(characterFrequency.containsKey(ch)) {
                int lastIndex = characterFrequency.get(ch);
                currentLength = Math.max(currentLength, i-lastIndex);
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            } else {
                currentLength++;
            }
            characterFrequency.put(ch, i);
        }
        return maxLength;
    }
}
