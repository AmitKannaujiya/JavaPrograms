package practice.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LargestPalendrom {

    public static void main(String[] args) throws IOException {
        LargestPalendrom obj = new LargestPalendrom();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int x = Integer.parseInt(br.readLine());
            System.out.println(obj.nextPalendrome(x));
        }
    }
     int nextPalendrome(int x) {
        int n =  x;
        ArrayList<Integer> nos = new ArrayList<>();
        while (n > 0) {
            nos.add(n%10);
            n=n/10;
        }
        int[] array = new int[nos.size()];
        for (int i = nos.size()-1 ; i >=0; i--) {
            array[(nos.size() -1) - i] = nos.get(i);
        }
        int min=1;
        int start = 0;
        int end = nos.size() - 1;

        while (start < end) {
            if(array[start] != array[end]) {
                if(array[start] > array[end]) {
                    array[end] = array[start];
                } else {
                    array[start] = array[start] +1;
                    array[end] = array[start];
                }
            }
            start++;
            end--;
        }
        int neNo= getNo(array);
        if(neNo > x) {
            return neNo;
        }
        if(nos.size() % 2 == 1 ) {
            array[start] = array[start] +1;
        }
        return getNo(array);
     }
     // 11234
     private int getNo(int [] array) {
         int no = 0;
         int factor=10;
         for (int i = 0; i < array.length ; i++) {
//             if(i > 0) {
//                 factor = 10;
//             }
             no = no * factor + array[i];
         }
         return no;

     }
}
