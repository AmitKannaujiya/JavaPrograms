package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by amit on 20/11/18.
 */
public class PrimeNoCheck {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        printPrimeNoTillNo(N);

    }

    static void printPrimeNoTillNo(int N) {
        for (int i = 2; i < N; i++) {
            if (checkPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    static boolean checkPrime(int n) {

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
