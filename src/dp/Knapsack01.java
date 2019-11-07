package dp;

import java.util.ArrayList;

class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class Knapsack01 {
    public static void main(String[] args) {
        System.out.println(knapsack(5));
    }

    public static int knapsack(int maxSum) {
        ArrayList<Item> items = new ArrayList<Item>();
        Item item1 = new Item(1, 6);
        items.add(item1);
        Item item2 = new Item(2, 10);
        items.add(item2);
        Item item3 = new Item(3, 12);
        items.add(item3);

        return knapsackUtills(maxSum, items);
    }

    /*
     cache[1] = 6
     cache[2] = 12
     cache[3] = 18
     cache[4] = 

     */
//    public int knapsackUtills(int maxSum, ArrayList<Item> items) {
//        int cache[] = new int[maxSum+1];
//        for(int i=0; i< items.size(); i++) {
//            Item item = items.get(i);
//            for(int j=1; j<=maxSum; j++) {
//                if(j-item.weight>= 0) {
//                    cache[j] = Math.max(cache[j], cache[j-item.weight]+item.value);
//                } else {
//                    continue;
//                }
//            }
//        }
//        return cache[maxSum];
//    }
    public static int knapsackUtills(int maxsum, ArrayList<Item> items) {
        int[][] cache = new int[items.size() + 1][maxsum + 1];

        for (int i = 1; i <= items.size(); i++) {
            for (int j = 0; j <= maxsum; j++) {
                Item item = items.get(i - 1);
                if (j - item.weight >= 0) {
                    cache[i][j] = Math.max(cache[i - 1][j - item.weight] + item.value, cache[i - 1][j]);
                } else {
                    cache[i][j] = cache[i - 1][j];
                }
            }
        }
        for (int i = 0; i <= items.size(); i++) {
            for (int j = 0; j <= maxsum; j++) {
                System.out.print(cache[i][j] + " ");
            }
            System.out.println();
        }
        return cache[items.size()][maxsum];
    }

}


