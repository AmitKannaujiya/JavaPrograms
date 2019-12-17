package algoMadeEasyBook;

import Utills.Utills;

import java.util.ArrayList;
import java.util.List;

/**
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 * <p>
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 */
public class SequencialDigitLeetCode {
    public static void main(String[] args) {
        List<Integer> list = sequentialDigits(100, 300);
        Utills.printArrayListInteger((ArrayList<Integer>) list);

        list = sequentialDigits(1000, 13000);
        Utills.printArrayListInteger((ArrayList<Integer>) list);
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        int divisor = getMaxDivisor(low);
        int n = low / divisor;
        while (low < high) {

            int no = generateSequencialNo(low, n, divisor);
            if (no > low) {
                list.add(no);
                n++;
            } else {
                n = 1;
                divisor *= 10;
                continue;
            }
            low = n * divisor;
        }
        return list;
    }

    static int getMaxDivisor(int num) {
        int divisor = 1;
        while (num / divisor >= 10) {
            divisor *= 10;
        }
        return divisor;
    }

    static int generateSequencialNo(int num, int n, int divisor) {

        int nextNo = 0;
        int nDividor = divisor;
        while (nDividor >= 1) {
            nextNo += n * nDividor;
            n++;
            nDividor /= 10;
        }
        if(n > 10) {
            return num;
        }
        return nextNo;
    }

    static int generateSequencialNo(int num, boolean first) {
        int divisor = getMaxDivisor(num);
        int n = num / divisor;
        int nextNo = 0;
        while (true) {
            int nDividor = divisor;
            while (nDividor >= 1 && n < 10) {
                nextNo += n * nDividor;
                n++;
                nDividor /= 10;
            }
            if (nextNo < num && n == 10) {
                n = 1;
                nDividor *= 10;
            } else if (nextNo < num) {
                n = (num / divisor) + 1;
            } else {
                break;
            }
        }
        return nextNo;
    }
}
