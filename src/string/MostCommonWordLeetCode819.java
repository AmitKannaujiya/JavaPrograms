package string;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Arrays;

public class MostCommonWordLeetCode819 {
    public static void main(String[] args) {
        String paragraph = "Bob. hIt, baLl";
        String[] banned = new String[]{"bob", "hit"};
        System.out.println(mostCommonWord(paragraph, banned));

    }

    static String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph == null || paragraph.isEmpty()) {
            return paragraph;
        }
        HashMap<String, Integer> map = new LinkedHashMap<>();
        List<String> list = Arrays.asList(banned);
        String key = "";
        int max = Integer.MIN_VALUE;
        String[] words  = paragraph.replaceAll("[^a-zA-z]", " ").toLowerCase().split(" ");
        for(String word : words) {
            if(!list.contains(word) && !word.isEmpty()) {
                int val = map.getOrDefault(word, 0) + 1;
                map.put(word, val);
                if(max < val) {
                    max = val;
                    key = word;
                }
            }
        }
        return key;

    }
}
