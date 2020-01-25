package array;

import java.util.ArrayList;
import java.util.List;

public class RunLengthEncodingLeetCode {
    public static void main(String[] args) {
        RunLengthEncodingLeetCode obj = new RunLengthEncodingLeetCode();
        obj.testCompress();
    }

    void testCompress() {
        char[] chars = new char[]{'a', 'a', 'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'};
        //["a","a","a","b","b","a","a"]
        compress(chars);
    }

    public int compress(char[] chars) {
        if (chars.length <= 1) {
            return chars.length;
        }
        int length = 0;
        int count;
        int j;
        for (int i = 0; i < chars.length; ) {
            count = 1;
            j = i + count;
            chars[length++] = chars[i];
            while (j < chars.length && chars[i] == chars[j]) {
                count++;
                j++;
            }
            if (count > 1 && count <= 9) {
                chars[length++] = (char) (count + '0');
            } else if (count > 9) {
                List<Character> list = new ArrayList<>();
                int count1 = count;
                while (count1 > 0) {
                    char c = (char) (count1 % 10 + '0');
                    list.add(0, c);
                    count1 /= 10;
                }
//                length += list.size() + 1;
                for (int k = 0; k < list.size(); k++) {
                    chars[length++] = list.get(k);
                }
            } else {
                //length += 1;
            }
            i += count;
        }
        return length;
    }
}
