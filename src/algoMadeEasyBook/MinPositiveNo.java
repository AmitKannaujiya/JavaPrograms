package algoMadeEasyBook;

import java.util.HashMap;

public class MinPositiveNo {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 6, 4, 1, 2}));
        //System.out.println(new Exception());
        System.out.println(solution(new int[]{3, 4, -1, 1}));
        System.out.println(solution(new int[]{1, 0, 2}));
        System.out.println(solution(new int[]{2, 3, 7, 6, 8, -1, -10, 15}));

    }

    public static int solution(int[] A) {
        int missing = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                map.put(A[i], A[i]);
            }
        }
        if (map.size() == 0) {
            return missing;
        }
        for (int no : map.keySet()) {
            if (no - missing >= 1) {
                return missing;
            }
            missing++;
        }
        return missing;
    }
}
