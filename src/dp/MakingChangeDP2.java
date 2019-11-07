package dp;

public class MakingChangeDP2 {

    int COINS[] = {1, 3, 5};

    /**
     * here we are iterating each coin and try to calculate weither including this coin will
     * sum will not be 0;
     *
     * @param
     * @return
     */
//    int makingChange(int n, int count, int min) {
//
//        for (int i = 0; i < COINS.length; i++) {
//
//            if(n- COINS[i] >=0) {
//               // return 1+ Math.min(makingChange(n-COINS[i], 0, 0), makingChange(n, 0, 0))
//            }
//        }
//    }


    int makingChange(int sum) {
        if (sum == 0) {
            return 0;
        }
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < COINS.length; i++) {
            if (sum - COINS[i] >= 0) {
                int currentMin = makingChange(sum - COINS[i]);
                if (currentMin < min) {
                    min = currentMin;
                }
            }
        }
        return min + 1;
    }

    int makingChange_top_down(int sum) {
        int cache[] = new int[sum + 1];
        cache[0] = 0;
        for (int i = 1; i < sum + 1; i++) {
            cache[i] = -1;
        }
        return makingChange_top_down(sum, cache);
    }

    int makingChange_top_down(int n, int[] cache) {
        if (cache[n] >= 0) {
            return cache[n];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < COINS.length; i++) {
            if (n - COINS[i] >= 0) {
                int currentMin = makingChange_top_down(n - COINS[i], cache);
                if (min > currentMin) {
                    min = currentMin;

                }
            }
        }
        return cache[n] = min + 1;
    }

    int makingChange_bottom_up(int sum) {
        int cache[] = new int[sum + 1];
        cache[0] = 0;

        for (int i = 1; i <= sum; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < COINS.length; j++) {
                if (i - COINS[j] >= 0) {
                    int currentMin = cache[i - COINS[j]] + 1;
                    if (min > currentMin) {
                        min = currentMin;
                    }
                }

            }
            cache[i] = min;
        }
        return cache[sum];
    }

}
