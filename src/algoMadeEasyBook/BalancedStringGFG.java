package algoMadeEasyBook;

public class BalancedStringGFG {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        int len = str.length();

        System.out.println(minimumAddition(str, len));
    }

    static int MAX = 26;

    private static int minimumAddition(String str, int len) {
        int count[] = new int[MAX];
        int max = 0;
        int maxDiff = 0;
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
            if (count[c - 'a'] > max) {
                max = count[c - 'a'];
            }
        }
        System.out.println("detail 1 =>");
        int count1 = 0;
        for (int i = 0; i < MAX; i++) {
            if (count[i] > 0) {
                System.out.println(++count1 + ". char : " + ((char) (i + 'a')) + " difference : " + (max - count[i]));
                maxDiff += max - count[i];
            }
        }
        System.out.println(maxDiff);
        maxDiff = 0;
        count1 = 0;
        System.out.println("detail 2 =>");
        for (char c : str.toCharArray()) {
            if (count[c - 'a'] > 0) {
                System.out.println(++count1 + ". char : " + c + " difference : " + (max - count[c - 'a']));
                maxDiff += max - count[c - 'a'];
            }
        }
        return maxDiff;
    }
}
