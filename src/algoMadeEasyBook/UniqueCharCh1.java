package algoMadeEasyBook;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class UniqueCharCh1 {
    /*
      Constrains : Input Types : a-z and A-Z
      idea :  Brute force : start from 0 iterate all characters check if that element reperats or not
            Time:  O(n2), Memory: O(1)
            2) Use Hash map : Store each element count in array , and if count is greater than 0 return false else at the end return true;
            Time : O(n) , Memory : O(n)


     */
    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'S', 'A', 'n', 'Z', 'z', 'S'};
        System.out.println("Check Unique charaters in string");
        System.out.println(isUnique(chars));
        System.out.println(isUnique1(chars));
        System.out.println(isUnique2(chars));
        System.out.println(isPermutationOfString(null, "dddc"));

        // ======== check permutations ==========//
        System.out.println("Check Permutions");
        System.out.println(isPermutationOfString("abc", "acb"));
        System.out.println(isPermutationOfString("abc", "aac"));
        System.out.println(isPermutationOfString("abc", "bca"));
        System.out.println(isPermutationOfString("abcd", "dddc"));
        System.out.println(isPermutationOfString(null, "dddc"));
        System.out.println(isPermutationOfString("abc", null));

        // ========== Replace Space in string with '%20', in place ==== //
        System.out.println("Replace Space in string with '%20'");
        System.out.println(replaceSpaceWithChar("this is a boy      ", 13));
        System.out.println(replaceSpaceWithChar("We see many people who jump straight into coding, ignoring all previous steps. This is bad in real life, and it’s bad when done at your interview. Never, ever jump straight into coding before having thought about and discussed constraints, ideas and complexities with your interviewer.                                                                                                                                                                                                                                                                     ", 285));


    }

    private static boolean isUnique(char[] chars) {
        boolean map[] = new boolean[58];
        for (char character : chars) {
            if (!map[character - 'A']) {
                map[character - 'A'] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isUnique1(char[] chars) {
        int maxChar = 0;
        for (char c : chars) {
            if (maxChar < c) {
                maxChar = c;
            }
        }
        boolean map[] = new boolean[maxChar + 1 - 65];
        for (char character : chars) {
            if (!map[character - 'A']) {
                map[character - 'A'] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isUnique2(char[] chars) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char characters : chars) {
            if (hashMap.containsKey(characters)) {
                return false;
            } else {
                hashMap.put(characters, 1);
            }
        }
        return true;
    }


    /*
      -------------------------
      String Permutation check
      -------------------------
     */

    /**
     * Constraints : 1) How long does string is ?
     * 2) Length should be same
     * <p>
     * Idea : abc  acbd  => Length should be same
     * Bruthforce : 1) check length of both Strings, now comapre 1 charater from 1 to second string if it is found,
     * then check next else it is not permutation.
     * Time : O(n2), memory: O(1)
     * <p>
     * 2) Create HasMap or count array, iterate over all characters of one ans store count, now iterate second and reduce count by 1,
     * if all counts become 0 then scan HasMap or count array. then return true else false.
     */

    private static boolean isPermutationOfString(String first, String second) {
        if (first == null || second == null) {
            return false;
        }

        if (first.length() != second.length()) {
            return false;
        }
        HashMap<Character, Integer> hashMap = new LinkedHashMap<>();

        for (char ch : first.toCharArray()) {
            if (hashMap.containsKey(ch)) {
                Integer count = hashMap.get(ch);
                hashMap.put(ch, count + 1);
            } else {
                hashMap.put(ch, 1);
            }
        }

        for (char ch : second.toCharArray()) {
            if (!hashMap.containsKey(ch)) {
                return false;
            }
            Integer count = hashMap.get(ch);
            if (count < 0) {
                return false;
            }
            hashMap.put(ch, count - 1);
        }
        for (Integer integer : hashMap.values()) {
            if (integer != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Problem : Replace Space with '%20' in a string
     * <p>
     * ex :  'this is a boy      ' => 'this%20is%20a%20boy'
     * <p>
     * <p>
     * <p>
     * Constraints :  1) will length of string accomodate extra charaters.
     * 2) what will be max length of string ?
     * <p>
     * Idea : Efficient 1) a) count no of space from actual length. b) start loop from 2* spaceCount and start shifting
     * string characters to the last and replace extra space '%20'
     *
     * @param str
     * @param len
     * @return
     */
    private static String replaceSpaceWithChar(String str, int len) {
        if (len > str.length()) {
            return str;
        }
        int count = 0;
        char[] strArray = str.toCharArray();

        for (int i = 0; i < len; i++) {
            if (strArray[i] == ' ') {
                count++;
            }
        }
        count *= 2;

        int j = len - 1;
        while (count > 0) {

            while (strArray[j] != ' ') {
                strArray[count + j] = strArray[j];
                j--;
            }
            strArray[count + j] = '0';
            strArray[count + j - 1] = '2';
            strArray[count + j - 2] = '%';
            count -= 2;
            j--;

        }

        return String.valueOf(strArray);
    }


}


