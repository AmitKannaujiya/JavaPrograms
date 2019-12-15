package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HackerBlueOptima {
    int a =100;
    public static void main(String[] args) throws IOException {
        int a =200;
        System.out.println(a);
        int c[] = {1, 2,3,4};
        final int b[] = {1, 3, 4, 5};
         boolean b1 =true;
         boolean b2 = false;
         boolean b3 =true;
         if(b1 & b2 | b2 &b3 | b2) {
             System.out.println("yes");
         }
        if(b1 & b2 | b2 &b3 | b2 | b1) {
            System.out.println("ok");
        }

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        //int testCase = Integer.parseInt(br.readLine());
//        EquiliseArrayHcrank obj = new EquiliseArrayHcrank();
//
//        //while (testCase-- > 0) {
//        int size = Integer.parseInt(br.readLine());
//        int[] array = new int[size];
//        // to read multiple integers line
//        String line = br.readLine();
//        String[] strs = line.trim().split("\\s+");
//        for (int i = 0; i < size; i++) {
//            array[i] = Integer.parseInt(strs[i]);
//        }
//        obj.BS(int[]);
        System.out.println(solve(4, new int[]{5, 6, 3, 1}));
    }


    static long solve(int N,int[] T){
        // Write Your Code Here
        int dp[] = new int[N+1];
        int currentCost = Math.abs(T.length -0)*T[0];
        int minCost = currentCost;
        dp[0] = T[0];
        int costSum = dp[0];
        for(int i=1; i<T.length; i++) {
            currentCost = dp[i-1] + T[i]*(T.length -i);
            costSum = Math.min(T[i], costSum);
            dp[i] = dp[i-1] + costSum;
            minCost = currentCost > minCost ?  minCost : currentCost;
        }
        return minCost;
    }

//    public int[] BS(int array[]) {
//        int b[] = new int[array.length];
//        b[0] =  1;
//        for (int i = 1; i < array.length; i++) {
//            int sequence = 1;
//
//            for (int j = 0; j < i; j++) {
//                int lastNo = array[j];
//
//                if(lastNo < array[i]) {
//                    current++;
//                }
//            }
//            b[i] = sequence;
//        }
//    }





}
