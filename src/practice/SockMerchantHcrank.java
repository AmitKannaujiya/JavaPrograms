package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by amit on 9/11/18.
 */
public class SockMerchantHcrank {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int testCase = Integer.parseInt(br.readLine());
        SockMerchantHcrank obj = new SockMerchantHcrank();

        //while (testCase-- > 0) {
        int size = Integer.parseInt(br.readLine());
        int[] array = new int[size];
        // to read multiple integers line
        String line = br.readLine();
        String[] strs = line.trim().split("\\s+");
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(obj.getMatchingPairs(array, size));

        //System.out.println(obj.findEquilibriumPoint(array));


        //}
    }

    private int getMatchingPairs(int[] array, int size) {
        boolean[] pairedSocks = new boolean[100+1];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (pairedSocks[array[i]]) {
                count++;
                pairedSocks[array[i]] = false;
            } else {
                pairedSocks[array[i]] = true;
            }

        }
        return count;

    }

}
