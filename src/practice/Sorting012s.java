package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by amit on 2/11/18.
 *
 2
 5
 0 2 1 2 0
 3
 0 1 0
 */
public class Sorting012s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        Sorting012s obj = new Sorting012s();

        while (testCase-- > 0) {
            int size = Integer.parseInt(br.readLine());
            int[] array = new int[size];
            // to read multiple integers line
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            for (int i = 0; i < size; i++) {
                array[i] = Integer.parseInt(strs[i]);
            }
            obj.sortInGroups(array);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < size; i++)
                sb.append(array[i] + " ");

            // finally printing the string
            System.out.println(sb);

        }

    }

    private void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j]=temp;
    }

    private void sortInGroups(int[] array) {
        int startIndex = 0;
        int endIndex = array.length-1;
        int count=0;
        while (count!=2) {
            while (startIndex < endIndex) {

                while (startIndex <= array.length-1 && array[startIndex] == count) { startIndex++;}
                while (endIndex >=0&& array[endIndex] != count) { endIndex--;}

                if(startIndex< endIndex && array[startIndex]!=count && array[endIndex]== count) {
                    swap(array, startIndex, endIndex);
                }
            }
            endIndex = array.length-1;
            count++;

        }

    }


}
