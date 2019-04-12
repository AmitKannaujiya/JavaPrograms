package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by amit on 9/11/18.
 */
public class EquiliseArrayHcrank {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int testCase = Integer.parseInt(br.readLine());
        EquiliseArrayHcrank obj = new EquiliseArrayHcrank();

        //while (testCase-- > 0) {
        int size = Integer.parseInt(br.readLine());
        int[] array = new int[size];
        // to read multiple integers line
        String line = br.readLine();
        String[] strs = line.trim().split("\\s+");
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(strs[i]);
        }

        //System.out.println(obj.findEquilibriumPoint(array));


        //}
    }

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        int[] count = new int[100];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]+= 1;
        }
        int steps = 0;
        ArrayList<Integer> moreThanOne = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(count[arr[i]]== 1) {
                steps += 1;
            } else if(count[arr[i]] > 1 && !moreThanOne.contains(count[arr[i]])) {
                moreThanOne.add(count[arr[i]]);
            }
        }
        if(moreThanOne.size() == 1) {
            return steps;
        }
        int Max= 0;
        for(Integer num: moreThanOne) {
            if(num > Max) {
                Max = num;
            }
        }
        for(Integer num: moreThanOne) {
            if(num != Max) {
                steps += num;
            }
        }

        return steps;
    }

    // Complete the equalizeArray function below.
    static int equalizeArrayV2(int[] arr) {
        int[] count = new int[100];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]+= 1;
            if(count[arr[i]] > max) {
                max = count[arr[i]];
            }
        }
        return arr.length - max;

    }

}
