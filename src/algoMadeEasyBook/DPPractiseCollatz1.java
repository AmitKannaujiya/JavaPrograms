package algoMadeEasyBook;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class DPPractiseCollatz1 {
    public static void main(String[] args) {
        DPPractiseCollatz1 obj = new DPPractiseCollatz1();
        System.out.println(obj.noOfStepsToTransformTwo1(7));

        System.out.println(obj.noOfStepsToTransformTwo1DP(7));

    }
    public int noOfStepsToTransformTwo1DP(int k) {
        int maxSteps = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, 0);
        for(int i=2; i<=k; i++) {
            int steps = getStepsDP(i, map);
            maxSteps = Math.max(maxSteps, steps);
        }
        return maxSteps;
    }
    public int getStepsDP(int n, HashMap<Integer, Integer> map) {
        if(n == 1) {
            return 0;
        }
        if(map.containsKey(n)) {
            return map.get(n);
        }
        if(n % 2 == 0) {
            int steps = getStepsDP(n/2, map) + 1;
            map.put(n, steps);
        } else {
            int steps = getStepsDP((3 * n) + 1, map ) + 1;
            map.put(n, steps);
        }
        return map.get(n);
    }

    public int noOfStepsToTransformTwo1(int k) {
        int maxSteps = Integer.MIN_VALUE;
        for(int i=2; i<=k; i++) {
            int steps = getSteps(i);
            maxSteps = Math.max(maxSteps, steps);
        }
        return maxSteps;
    }

    public int getSteps(int n) {
        if(n == 1) {
            return 0;
        } else if(n % 2== 0) {
            return getSteps(n/2) + 1;
        } else {
            return getSteps(3 * n + 1) + 1;
        }
    }
}
