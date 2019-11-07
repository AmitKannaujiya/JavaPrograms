package algoMadeEasyBook;

public class UglyNoTest {

    public static void main(String[] args) {
        System.out.println(nthUglyNo(150));
        System.out.println(nthUglyNo(11));

        System.out.println(getUglyNoDP(150));
    }

    static int nthUglyNo(int n) {
        int sequence = 1;
        while (n-- > 0) {
            while (sequence != 1 && checkUgly(sequence) != true) {
                sequence++;
            }
            sequence++;
        }
        return --sequence;
    }

    static boolean checkUgly(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;

    }

    static int getUglyNoDP(int no) {
        int cache[] = new int[no + 1];
        cache[0] = 1;
        int next_ugly_no_2 = 2;
        int next_ugly_no_3 = 3;
        int next_ugly_no_5 = 5;
        int next_no = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i <= no; i++) {
            next_no = Math.min(next_ugly_no_2, Math.min(next_ugly_no_3, next_ugly_no_5));
            cache[i] = next_no;

            if (next_ugly_no_2 == next_no) {
                i2++;
                next_ugly_no_2 = cache[i2] * 2;
            }
            if (next_ugly_no_3 == next_no) {
                i3++;
                next_ugly_no_3 = cache[i3] * 3;
            }
            if (next_ugly_no_5 == next_no) {
                i5++;
                next_ugly_no_5 = cache[i5] * 5;
            }
            //cache[i] = next_no;

        }
        return cache[no];

    }
}
