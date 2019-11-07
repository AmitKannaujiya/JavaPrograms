package algoMadeEasyBook;

public class ProjectEuler {

    public static void main(String[] args) {
        System.out.println(countDivider3or5(1000));
        System.out.println(sumEvenTermsFibonacci(400000));
    }

    static int countDivider3or5(int n) {
        int count = 0;
        for (int i = 3; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                count += i;
            }
        }
        return count;
    }

    static long sumEvenTermsFibonacci(long no) {
        int a = 0, b = 1;
        long sum = 0;
        while (b < no) {
            b = b + a;
            a = b - a;
            if (b % 2 == 0) {
                sum += b;
            }

            //System.out.println(b);
        }
        return sum;
    }
}
