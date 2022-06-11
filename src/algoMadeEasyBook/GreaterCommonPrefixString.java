package algoMadeEasyBook;

public class GreaterCommonPrefixString {
    public static void main(String[] args) {
        String[] words = {"geeksforgeeks", "geeks","geek", "geekzone", "geeker"};
        GreaterCommonPrefixString obj =new GreaterCommonPrefixString();
        System.out.println(obj.getLongestCommonPrefix(words));
        String[] words2 = {"apple","appe", "appril"};
        System.out.println(obj.getLongestCommonPrefix(words2));

    }

    public String getLongestCommonPrefix(String[] words) {
        int minLen = Integer.MIN_VALUE;
        int index =0;
        for (int i=0; i<words.length; i++) {
            String word = words[i];
            int len = word.length();
            if(minLen > len) {
                minLen = len;
                index = i;
            }
        }
        String smallestWord = words[index];
        for (int i = 0; i < words.length; i++) {
            if (i != index) {
                String match = matchCharacters(words[i], smallestWord);
                if(match.length() < smallestWord.length()){
                    smallestWord = match;
                }
            }
        }
        return smallestWord;
    }

    public String matchCharacters(String s1, String s2) {
        int i=0;
        while (i < s1.length() && i< s2.length()) {
            if(s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            i++;
        }
        return s1.substring(0, i);
    }

}


