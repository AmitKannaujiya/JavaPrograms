package algoMadeEasyBook;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class PairElementSumDivisible {
    public static void main(String[] args) {

    }

    // a[] = {9, 5, 3, 1} divisible by 6 => (9,3)  , (5,1)
    static boolean pairElementsSumDvisible(int a[], int k) {
        if (a.length % 2 == 1) {
            return false;
        }
        HashMap<Integer, Integer> rem = new HashMap<>();
        // To store frequency of each remainder
        for (int i = 0; i < a.length; i++) {
            int remainder = a[i] % k;
            if (!rem.containsKey(remainder)) {
                rem.put(remainder, 0);
            } else {
                rem.put(remainder, rem.get(remainder) + 1);
            }
        }

        // Now check each ferquency occurance with no .
        for (int i = 0; i < a.length; i++) {
            int remainder = a[i] % k;
            int freq = rem.get(remainder);

            if (2 * remainder == k) {
                // this should be even , remainder =3, feq = 2 => (9, 3)
                if (freq % 2 == 1) {
                    return false;
                }
            } else if (remainder == 0) {

                // this should be even , remainder =0, feq = 2 => (12, 6)
                if (freq % 2 == 1) {
                    return false;
                }
            } else {
                // remainder and k-remainder should be equal frequency
                int rest = k - remainder;
                if (rem.containsKey(rest)) {

                } else {
                    return false;
                }
            }


        }
    }
}
