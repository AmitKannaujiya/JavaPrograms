package algoMadeEasyBook;

public class IntegerPalindrom {
    public static void main(String[] args) {
        System.out.println("Check whether sum of digits of no is Palindom");
        System.out.println(isDigitSumPalendrom(56));
        System.out.println(isDigitSumPalendrom(994));
        System.out.println(isDigitSumPalendrom(1234));

        System.out.println("Check Whether no is palindrom or no");
        System.out.println(checkNoPalindrom(123321));
        System.out.println(checkNoPalindrom(2332));
        System.out.println(checkNoPalindrom(2331));

        System.out.println(checkPalindromRec(2332) ? "Yes" : "No");
        System.out.println(checkPalindromRec(2331) ? "Yes" : "No");


    }
    static boolean checkPalindromRec(int num) {
        long divisor = getMaxDivisor(num);
        return checkDivisorPalindromRec(num, divisor);
    }

    static boolean checkDivisorPalindromRec(int num, long divisor) {
        if(num <= 0) {
            return true;
        }
        int trailing = num % 10;
        long leading = num / divisor;
        return trailing == leading && checkDivisorPalindromRec((int) (num % divisor)/10, divisor/100);

    }

    static String checkNoPalindrom(int num) {
        return isSumPalindrom(num) ? "Yes" : "No";
    }
    static String isDigitSumPalendrom(int num) {
        int sumDigit = getDigitSum(num);
        return isSumPalindrom(sumDigit) ? "Yes" : "No";
    }
    static long getMaxDivisor(int num) {
        long divisor = 1;
        while (num / divisor >= 10) {
            divisor *=  10;
        }
        return divisor;
    }
    static int getDigitSum(int num) {
        int sumDigit = 0;
        while(num > 0) {
            sumDigit += num % 10;
            num /= 10;
        }
        return sumDigit;
    }
    // check if sum of digits of no is palindrom
    static boolean  isSumPalindrom(int numSum) {
        long divisor =  getMaxDivisor(numSum);
        while (numSum > 0) {
            int trailingNum = numSum % 10;
            long headNum = numSum / divisor;
            if(trailingNum != headNum) {
                return false;
            }
            numSum = (int)(numSum % divisor) / 10;
            divisor /= 100;
        }
        return  true;
    }
}
