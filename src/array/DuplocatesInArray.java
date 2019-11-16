package array;

import java.util.ArrayList;

public class DuplocatesInArray {
    public static void main(String[] args) {
        System.out.println(getDuplicates(new int[]{2, 1, 2, 1}));
    }
    // this will not work for negative nos
    static ArrayList<Integer> getDuplicates(int a[]) {
        ArrayList<Integer> dups = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int index = Math.abs(a[i]) - 1;
            if (a[index] > 0) {
                a[index] = -a[index];
            } else {
                if (!dups.contains(a[i])) {
                    dups.add(a[i]);
                }
            }
        }
        return dups;
    }
}
