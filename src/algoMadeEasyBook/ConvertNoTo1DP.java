package algoMadeEasyBook;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ConvertNoTo1DP {
    public static void main(String[] args) {
        ConvertNoTo1DP obj = new ConvertNoTo1DP();
        System.out.println(obj.getNoOfStepsTransformTo1(7));
        System.out.println(obj.getNoOfStepsTransformTo1(11));
    }

    public int getNoOfStepsTransformTo1(int n) {
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, 0);
        map.put(0, 0);
        return getNoOfStepsTransformTo1(n, map);
    }

    public int getNoOfStepsTransformTo1(int n, HashMap<Integer, Integer> map) {
        if(n ==  1) {
            return 0;
        }
        if(map.containsKey(n)) {
            return map.get(n);
        }
        if(n % 2 == 0) {
            int steps = getNoOfStepsTransformTo1(n / 2, map) + 1;
            map.put(n, steps);
        } else {
            int steps = Math.min(getNoOfStepsTransformTo1(n+1, map) + 1, getNoOfStepsTransformTo1(n-1, map) + 1);
            map.put(n, steps);
        }
        return map.get(n);
    }

}
