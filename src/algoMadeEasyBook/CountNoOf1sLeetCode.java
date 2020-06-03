package algoMadeEasyBook;

import Utills.Utills;

public class CountNoOf1sLeetCode {
    public static void main(String[] args) {
        CountNoOf1sLeetCode obj = new CountNoOf1sLeetCode();
        Utills.printArray(obj.countBits(7));
    }

    public int[] countBits(int num) {
        int[] no = new int[num+1];
        no[0] = 0;
        for(int i =1; i <= num; i++) {
            int maxPowerOf2 = getNearestPowerOf2(i);
            int count =0 ;
            for(int j=maxPowerOf2; j >=0; j--) {
                if((i & 1<< j) != 0) {
                    count++;
                }
            }
            no[i]=count;
        }
        return no;
    }
    
    private int getNearestPowerOf2(int num) {
        if(num <=2) {
            return 1;
        }
        int count =1;
        while(num > (1 << ++count));
        return count;
    }
}