package array;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LongestStringHavingKDistinctCharaterSWT {
    public static void main(String[] args) {
        String str = "AAAHHIBC";
        int k = 2;
        LongestStringHavingKDistinctCharaterSWT obj = new LongestStringHavingKDistinctCharaterSWT();
        System.out.println(obj.getLongestStringHavingKDistinctCharacters(str, k));
        str = "ABHAHIHBC";
        k = 2;
        System.out.println(obj.getLongestStringHavingKDistinctCharacters(str, k));
    }

    private String getLongestStringHavingKDistinctCharacters(String str, int k) {
        int start = 0;
        String longest ="";
        int maxCount = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) +1);
            while(map.keySet().size() > k) {
                char oldCh = str.charAt(start);
                while(map.get(oldCh) > 0) {
                    oldCh = str.charAt(start++);
                    map.put(oldCh, map.get(oldCh)-1);
                }
                map.remove(oldCh);
            }
            if(map.keySet().size() == k) {
                if(i - start +1 >= maxCount) {
                    longest = str.substring(start, i+1);
                    maxCount = Math.max(maxCount, longest.length());
                }
            }
        }
        return longest;
    }
}