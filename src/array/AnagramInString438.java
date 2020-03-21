package array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramInString438 {

    public static void main(String[] args) {
        AnagramInString438 obj = new AnagramInString438();
        List<Integer> list =  obj.findAnagrams("cbaebabacd", "abc");

        list =  obj.findAnagrams("abab", "ab");
        list = obj.findAnagrams2("cbaebabacd", "abc");
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] count = new int[26];
        for(char ch : p.toCharArray()) {
            count[ch - 'a']++;
        }
        int k = p.length();
        for(int i=k-1; i < s.length(); i++) {
            int j = i - (k-1);
            char ch1 = s.charAt(j);
            int len = 0;
            int [] count2 = Arrays.copyOf(count, 26);
            while(len < k && j <= i && count2[ch1 - 'a']>0) {
                count2[ch1 - 'a']--;
                len++;
                j++;
                if(j > i) {
                    break;
                }
                ch1 = s.charAt(j);
            }
            if(len == k) {
                list.add(i-(k-1));
            }
        }
        return list;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length())
            return result;

        int[] targetCharactersFreq = new int[128];

        for (char targetChar : p.toCharArray()) {
            targetCharactersFreq[targetChar]++;
        }

        int remainingCharToBeAnagram = p.length();
        int startWindowIndex = 0;
        int endWindowIndex = 0;

        while (endWindowIndex < s.length()) {

            char currentChar = s.charAt(endWindowIndex);

            if (targetCharactersFreq[currentChar] >= 1) {
                remainingCharToBeAnagram--;
            }
            targetCharactersFreq[currentChar]--;
            endWindowIndex++;

            if (remainingCharToBeAnagram == 0) {
                result.add(startWindowIndex);
            }

            int windowLength = endWindowIndex - startWindowIndex;

            if (windowLength == p.length()) {
                char currentStartWindowChar = s.charAt(startWindowIndex);

                if (targetCharactersFreq[currentStartWindowChar] >= 0) {
                    remainingCharToBeAnagram++;
                }
                targetCharactersFreq[currentStartWindowChar]++;
                startWindowIndex++;
            }
        }
        return result;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] count = new int[26];
        int [] count2 =  new int[26];
        for(char ch : p.toCharArray()) {
            count[ch - 'a']++;
        }
        int k = p.length();
        for(int i=k-1; i < s.length(); i++) {
            int j = i - (k-1);
            char ch1 = s.charAt(j);
            int len = 0;
            count2 = count;
            while(len < k && count2[ch1 - 'a']>0) {
                count2[ch1 - 'a']--;
                len++;
                j++;
                ch1 = s.charAt(j);
            }
            if(len == k) {
                list.add(i-(k-1));
            }
        }
        return list;
    }
}
