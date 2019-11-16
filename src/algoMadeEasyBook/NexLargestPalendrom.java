package algoMadeEasyBook;

public class NexLargestPalendrom {
    // 12345  =>  12421
    // 397 => 400 => 404
    // 1234  => 1331
    // 1292  => 1300 => 1331
    public static void main(String[] args) {
        System.out.println(nextLargestPalendrom(12345));
        System.out.println(nextLargestPalendrom(397));
        System.out.println(nextLargestPalendrom(1234));
        System.out.println(nextLargestPalendrom(1292));
        System.out.println(nextLargestPalendrom(4567));
        System.out.println(nextLargestPalendrom(4991));
        System.out.println(nextLargestPalendrom(345699453));
    }

    static int nextLargestPalendrom(int no) {
        String nos = String.valueOf(no);
        int chars[] = new int[nos.length()];
        for(int i=0; i< nos.length(); i++) {
            chars[i] = Character.getNumericValue(nos.charAt(i));
        }
        //String.valueOf(chars)
        //int[] ab =new int[chars.length];

        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            chars[j--] = chars[i++];
        }

        int newNo = getNo(chars);
        if (newNo > no) {
            return newNo;
        }
        if (chars.length % 2 == 1) {
            int midIndex = (chars.length - 1) / 2;
            int carry = 0;
            int first= 0;
            do {
                int value = chars[midIndex] + carry;
                if(first == 0) {
                    value += 1;
                }
                chars[midIndex] = value %10;
                carry = value / 10;
                midIndex--;
                first++;
            } while (carry == 1);
        } else {
            int midIndex = (chars.length) / 2;
            int carry = 0;
            do {
                int value = chars[midIndex] + carry+1;
                chars[midIndex] = (value%10);
                carry = chars[midIndex] / 10;
                midIndex--;
            } while (carry == 1 || midIndex>=(chars.length-1)/2);
        }
        i = 0;
        j = chars.length - 1;
        while (i < j) {
            chars[j--] = chars[i++];
        }
        newNo = getNo(chars);
//        if (newNo > no) {
//            return newNo;
//        }

        return newNo;
    }

    static int getNo(int[] array) {
        int no =0;
        int power = 0;
        for (int i = array.length-1; i >-1 ; i--) {
            no += array[i] * Math.pow(10, power++);

        }
        return no;
    }
}
