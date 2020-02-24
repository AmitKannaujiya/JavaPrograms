package dp;

import java.util.HashMap;
import java.util.LinkedHashMap;
public class NoOfJumpsDP {
    public static void main(String[] args) {
        int array [] =  new int[]{2,3,1,1,4};
        NoOfJumpsDP obj = new NoOfJumpsDP();
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
       // System.out.println(obj.minimumNoOfJumps(array, 0, 0));
        //System.out.println(obj.minimumNoOfJumpsDP(array, 0, 0, map));
        array = new int[] {1, 3, 5, 3, 3,1,1,1,1,1,1,1,1,4};
        System.out.println(obj.minimumNoOfJumpsDP(array, 0, 0, map));
        System.out.println(obj.minimumNoOfJumps(array, 0, 0));

    }

    private int minimumNoOfJumps(int[] array, int start, int noOfJumps) {
        if(start == array.length -1) {
            return noOfJumps;
        }
        if(array[start] == 0) {
            return Integer.MAX_VALUE;
        }
        int jump = array[start];
        int lastMax = Integer.MAX_VALUE;
        for(int i = 1; i<= jump; i++) {
            int jumpno = minimumNoOfJumps(array, start + i, noOfJumps +1);
            lastMax = Math.min(jumpno, lastMax);
        }
        return lastMax;
    }

    private int minimumNoOfJumpsDP(int[] array, int start, int noOfJumps, HashMap<Integer, Integer> map) {
        if(start == array.length -1) {
            return noOfJumps;
        }

        if(array[start] == 0) {
            return Integer.MAX_VALUE;
        }
        if(map.containsKey(start)) {
            return map.get(start);
        }
        int jump = array[start];
        int lastMax = Integer.MAX_VALUE;
        for(int i = 1; i<= jump; i++) {
            int jumpno = minimumNoOfJumpsDP(array, start + i, noOfJumps +1, map);
            lastMax = Math.min(jumpno, lastMax);
        }
        map.put(start, lastMax);
        return lastMax;
    }
}
