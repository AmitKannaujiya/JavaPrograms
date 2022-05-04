package string;

import java.util.HashSet;

public class PhasePalindrome {
    public static void main(String[] args) {
        String str1= "This#string%contains^special*characters&.";
        str1=str1.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(str1);
        PhasePalindrome pp= new PhasePalindrome();
        System.out.println(pp.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        String ss = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        int i=0;
        int j=ss.length()-1;
        while (i < j && ss.charAt(i)==ss.charAt(j)){
            i++;j--;
        }
        return i>=j;
    }

    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set =  new HashSet<>();
        for (Character c: allowed.toCharArray()) {
            set.add(c);
        }
        int res=0;
        for (String word: words) {
            boolean ress = true;
            for (Character c: word.toCharArray()) {
                if(!set.contains(c)){
                    ress=false;
                    break;

                }
            }
            if (ress) {
                res++;
            }
        }
        return res;
    }
}
