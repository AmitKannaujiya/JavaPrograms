package dp;

public class MackingChangeDP {

    static int COINS[] = {1, 6, 10};
    public static void main(String[] args) {

        MackingChangeDP obj = new MackingChangeDP();
        System.out.println(obj.makeChange(13));
        System.out.println(obj.makeChange1(12));
        System.out.println(obj.makeChangeBU(13));
        System.out.println(obj.makeChangeBUImp(18));
    }
     int makeChange(int c) {
         int minChange = Integer.MAX_VALUE;
         int change = 0;
        if(c <= 0) {
            return 0;
        }

        for(int coin : COINS) {
            if(c-coin >= 0) {
                change = makeChange(c - coin);
                if(minChange > change) {
                    minChange = change;
                }
            }
        }
        return minChange + 1;
     }

    public int makeChange1(int c) {
        if (c == 0) return 0;
        int minCoins = Integer.MAX_VALUE;
// Try removing each coin from the total and
// see how many more coins are required
        for (int coin : COINS) {
// Skip a coin if it’s value is greater

// than the amount remaining
            if (c - coin >= 0) {
                int currMinCoins = makeChange1(c - coin);
                if (currMinCoins < minCoins)
                    minCoins = currMinCoins;
            }
        }
// Add back the coin removed recursively
        return minCoins + 1;
    }

    int makeChangeBU(int c) {
        int CACHE[] = new int[c+1];
        for (int i = 0; i < c + 1; i++) {
            CACHE[i] = -1;
        }

        return makeChangeBU(c, CACHE);
    }

    private int makeChangeBU(int c, int[] cache) {
        if(c <= 0 ) {
            return 0;
        }
        if(cache[c] >= 0) {
            return cache[c];
        }
        int minChange = Integer.MAX_VALUE;

        for (int coin : COINS) {
            if(c-coin >= 0 ) {
                int currentChange = makeChangeBU(c-coin, cache);
                if(minChange > currentChange ) {
                    minChange = currentChange;
                }
            }
        }
        cache[c] = minChange +1;
        return cache[c];
    }

    private int makeChangeBUImp(int c) {
        int CACHE[] = new int[c+1];
        for (int i = 1; i < c+1; i++) {
            int minCoins = Integer.MAX_VALUE;

            for (int coin : COINS) {

                if(i -coin >=0 ) {
                    int currentChange = CACHE[i-coin] +1;

                    if(minCoins > currentChange ) {
                        minCoins = currentChange;
                    }
                }
            }
            CACHE[i] = minCoins;

        }
        return CACHE[c];
    }


}
