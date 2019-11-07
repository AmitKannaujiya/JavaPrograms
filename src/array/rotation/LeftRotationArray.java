package array.rotation;

import Utills.Utills;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by amit on 18/6/19.
 */
public class LeftRotationArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        int size = Integer.parseInt(br.readLine());
        int[] array = new int[size];
        // to read multiple integers line
        String line = br.readLine();
        String[] strs = line.trim().split("\\s+");
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(strs[i]);
        }
        LeftRotationArray obj = new LeftRotationArray();
        int a[] = new int[]{1, 2, 3, 4, 5, 6};
        obj.arrayJuggling(a, 2);
        Utills.printArray(a);
    }


    int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    void arrayJuggling(int a[], int d) {
        int n = a.length;
        int gcd = gcd(n, d);

        for (int i = 0; i < gcd; i++) {
            int j = i;
            int temp = a[i];
            while (true) {
                int k = j + d;
                if (k > n - 1) {
                    k = k - n;
                }
                if (k == i) {
                    break;
                }
                a[j] = a[k];
                j = k;
            }
            a[j] = temp;

        }
    }
}
