package array;
import java.util.*;

public class FrequencySortLeetCode {
    public static void main(String[] args) {
        FrequencySortLeetCode obj = new FrequencySortLeetCode();
        String s = "tree";
        System.out.println(obj.frequencySort(s));
        s = "raaeaedere";
        System.out.println(obj.frequencySort(s));
    }

    public String frequencySort(String s) {

        HashMap<Character, Integer > map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        StringBuilder sb1 = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : list) {
            for(int i=0; i < entry.getValue(); i++) {
                sb1.append(entry.getKey());
            }
        }
        return sb1.toString();
    }

}

class FreqChar {
    int count;
    char ch;
    public FreqChar(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}