package array;

//  Count no of indeses which are less then all element before it .

public class CountNoOfIndecesLessThanIt {

    public static void main(String[] args) {
        System.out.println(countNoOfIndesesLessThanIt(new int[]{4, 2, 1, 5, 6 , 3}));
        System.out.println(countNoOfIndesesLessThanIt(new int[]{1, 2, 3, 4}));
        System.out.println(countNoOfIndesesLessThanIt(new int[]{4,3,2,1}));

        System.out.println(countNoOfIndesesLessThanIt(new int[]{-4,-3, 2,-1}));

        System.out.println(countNoOfIndesesLessThanItOPT(new int[]{-4,-3, 2,-1}));
        System.out.println(smallestDivisor(new int[]{1,2,5,9}, 6));

    }

    static int smallestDivisor(int[] nums, int thresold) {
        int divisor = 1;
        int sum = Integer.MAX_VALUE;
        while(sum > thresold) {
            int currentSum = 0;
            for(int num : nums) {
                int result = (int)Math.round(num/divisor);
                currentSum += (result > 1 ? result : 1);
            }
            if(currentSum > thresold) {
                divisor++;
            }
            sum = currentSum;
        }
        return divisor;
    }


//4, 2, 1, 5, 6 , 3
    static private int countNoOfIndesesLessThanIt(int a[]) {
        int count = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length ; i++) {
            if(a[i] > min && a[i]> max) {
                count++;
            }
            if(a[i] > max) {
                max = a[i];
            }
            if(a[i] < min) {
                min = a[i];
            }
        }
        return count;
    }

    static private int countNoOfIndesesLessThanItOPT(int a[]) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length ; i++) {
            if(a[i]> max) {
                count++;
            }
            if(a[i] > max) {
                max = a[i];
            }
        }
        return count;
    }
}
