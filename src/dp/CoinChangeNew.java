package dp;

public class CoinChangeNew {
    int[] coins = new int[]{5,3,2,1};
    public static void main(String[] args) {
        CoinChangeNew obj=new CoinChangeNew();
        System.out.println("############### Make Minimum no of coins for sum C #################");
        System.out.println("############### Recursive Solution #################");
        System.out.println(obj.makeChangesNV(8));
        System.out.println(obj.makeChangesNV(12));
        System.out.println(obj.makeChangesNV(25));
        System.out.println("############### Top-Down Solution #################");
        System.out.println(obj.makeChangeTopDown(8));
        System.out.println(obj.makeChangeTopDown(12));
        System.out.println(obj.makeChangeTopDown(25));
        System.out.println("############### Bottom-Up Solution #################");
        System.out.println(obj.makeChangeBottomUp(8));
        System.out.println(obj.makeChangeBottomUp(12));
        System.out.println(obj.makeChangeBottomUp(25));
    }

    public int makeChangesNV(int c) {
        if(c== 0){
            return 0;
        }
        int min= Integer.MAX_VALUE-1;
        for (int i = 0; i < coins.length; i++) {
            if(c - coins[i] >=0){
                int minways = makeChangesNV(c- coins[i]);
                if(minways < min){
                    min = minways;
                }
            }
        }
        return min+1;
    }

    public int makeChangeTopDown(int c){
        int[] cache = new int[c+1];
        for (int i = 1; i < c + 1; i++) {
            cache[i] = -1;
        }
        cache[0] = 0;
        return makeChangeTopDown(c, cache);
    }

    private int makeChangeTopDown(int c, int[] cache) {
        if(cache[c] !=-1) {
            return cache[c];
        }
        int min= Integer.MAX_VALUE-1;
        for (int i = 0; i < coins.length; i++) {
            if(c - coins[i] >=0){
                int minways = makeChangesNV(c- coins[i]);
                if(minways < min){
                    min = minways;
                }
            }
        }
        cache[c] = min+1;
        return cache[c];
    }

    public int makeChangeBottomUp(int c){
        int[] cache = new int[c+1];

        for (int k = 1; k <=c; k++) {
            int min= Integer.MAX_VALUE-1;
            for (int i = 0; i < coins.length; i++) {
                if(k - coins[i] >=0){
                    int minways = cache[k- coins[i]] +1;
                    if(minways < min){
                        min = minways;
                    }
                }
            }
            cache[k] = min;
        }
        return cache[c];
    }
}
