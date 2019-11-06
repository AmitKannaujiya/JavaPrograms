package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.lang.String;
import java.lang.Integer;

/**
 * Created by amit on 21/11/18.
 */
public class AnagramMakeAnagramHcrank {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        while(T-- > 0) {
//            String a = br.readLine();
//            String b = br.readLine();
//            System.out.println(countDifference(a, b));
//        }

//        String b = br.readLine();
//        checkPadendrom(b);

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        // to read multiple integers line
        String line = br.readLine();
        String[] strs = line.trim().split("\\s+");
        BigInteger p=new BigInteger("1");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(strs[i]);
            p = p.multiply(new BigInteger(strs[i]));
        }
        System.out.println(p);


    }

    static void checkPadendrom(String s) {
        int st=0;
        int en=s.length();
        if(en == 1) {
            System.out.println("YES");
        }
        en--;
        while (st<en) {
            if(s.charAt(st)==s.charAt(en)) {
                st++;
                en--;
            } else {
                break;
            }
        }
        if (st>=en) {
            System.out.println("YES");
        }  else {
            System.out.println("NO");
        }

    }

    private static int countDifference(String a, String b) {
        int[] counting = new int[27];
        for (char c : a.toCharArray()) {
            counting[c-'a']++;
        }
        for (char c : b.toCharArray()) {
            counting[c-'a']--;
        }
        int count=0;
        for (int i = 0; i < 27; i++) {
            count += Math.abs(counting[i]);
        }
        return count;
    }
}
