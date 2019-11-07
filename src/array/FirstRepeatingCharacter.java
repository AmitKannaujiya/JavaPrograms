package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/**
 * Created by amit on 20/5/19.
 */
public class FirstRepeatingCharacter {

    public static void main(String[] args) {
        String s = "orgeeksfgeeks";
        FirstRepeatingCharacter obj = new FirstRepeatingCharacter();
        System.out.println("index of repeating character : " + obj.getFirstRepeatingCharacterIndex(s));
        System.out.println("index of repeating character : " + obj.getFirstRepeatingCharacterIndexV2(s));
    }

    public int getFirstRepeatingCharacterIndex(String s) {
        int b[] = new int[26];
        for (char c : s.toCharArray()) {
            b[c - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (b[s.charAt(i) - 'a'] > 1) {
                return i;
            }
        }
        return -1;
    }

    public int getFirstRepeatingCharacterIndexV2(String s) {
        int b[] = new int[26];

        HashMap<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                return map.get(c);
            } else {
                map.put(c, i);
            }
        }
        return -1;
    }
}
