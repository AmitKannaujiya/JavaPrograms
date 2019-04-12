package string;

/**
 * Created by amit on 11/12/18.
 */
public class CheckRotatedString {

    public static void main(String[] args) {
        System.out.println(checkRotatedString("ABCD", "CDAB"));
        System.out.println(checkRotatedString("ABCD", "ACBD"));
        System.out.println(checkRotatedString("123", "132"));
    }

    static boolean checkRotatedString(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        String p= s1+s1;
        int j=0;
        for (int i = 0; i < p.length(); i++) {

            if(p.charAt(i)==s2.charAt(j)) {
                j++;
            }else {
                j=0;
            }
            if(j== s2.length()) {
                return true;
            }
        }
        return false;
    }
}
