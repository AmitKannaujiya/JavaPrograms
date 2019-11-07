package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

/**
 * Created by amit on 21/11/18.
 */
public class HackerEarthTrainSeatNo {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            trainSeatNo(N);

        }


    }

    static void trainSeatNo(int N) {
        //String[] seats = new String{"WS", "MS", "AS"};
        String seat = "WS";
        if (N % 6 == 0 || N % 6 == 1) {
            seat = "WS";
        } else if (N % 3 == 0 || N % 3 == 1) {
            seat = "AS";
        } else {
            seat = "MS";
        }
        int q = 0;
        int rem = N % 12;
        int seatNo = 0;
        if (rem == 0) {
            q = N / 12;
            seatNo = 12 * q + 1 - (12 - rem);
        } else {
            q = N / 12 + 1;
            seatNo = (12 * q - rem + 1);
        }
        System.out.println(seatNo + " " + seat);

//        int rem =  N %12;
//        int q= N/12 + 1;
//        int seatNo = (12 * q - rem + 1);
//        System.out.println(seatNo + " "+ seat);
    }


}
