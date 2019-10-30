package array;

/**
 * Created by amit on 30/5/19.
 */
public class FirstNonReppeatingCharArray {

    public static void main(String[] args) {
        String word = "GEEKSFORGEEKS";
        FirstNonReppeatingCharArray obj = new FirstNonReppeatingCharArray();
        System.out.println(obj.getFirstNonRepeatingChar(word));
        System.out.println(obj.getFirstNonRepeatingChar2(word));

    }

    public int getFirstNonRepeatingChar(String s) {
        int x = 0;
        for (char c : s.toCharArray()) {
            x = x^ (int)c;
        }
        for (int i = 0; i < s.length(); i++) {
            int y = x ^ (int)s.charAt(i);
            if(y == 0) {
                return i;
            }
        }
        return -1;

    }

    public int getFirstNonRepeatingChar2(String s) {
        int x = 0;
        int b[] = new int[127];
        for (int i = 0; i < s.length(); i++) {
            b[(int)s.charAt(i)] += 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if(b[(int)s.charAt(i)] == 1){
                return i;
            }
        }
        return -1;

    }

}
