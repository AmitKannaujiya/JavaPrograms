package lru;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Vector;

/**
 * Created by amit on 13/7/18.
 */
public class LFUCache {

    HashMap<Integer, Integer> frequencyMap;
    int MINF = -1;

    HashMap<Integer, Integer> frequncy;

    int SIZE;

    public LFUCache(int capacity) {
        this.frequencyMap = new LinkedHashMap<>(capacity);
        this.frequncy = new LinkedHashMap<>();
        this.SIZE = capacity;
    }

    public int get(int key) {
        if (frequencyMap.containsKey(key)) {
            incrementF(key);
            System.out.println(frequencyMap.get(key));
            return frequencyMap.get(key);
            // increase frequency of element
            // return element
        }
        System.out.println(-1);
        return -1;

    }

    public void put(int key, int value) {
        if (SIZE == 0) {
            return;
        }
        if (isFull() && frequencyMap.get(key) == null) {
            // Evict element
            // 1 ) Remove LRU element
            //  2 ) if same element is present at multiple places
            //  3 ) evict LRU element only, who's frequency is low

            decrementF(key, value);

        }
        incrementF(key);
        frequencyMap.put(key, value);
    }

    private void decrementF(int key, int value) {
        frequencyMap.remove(MINF);
        frequncy.remove(MINF);
        //setMinPriority(-1);
//        int min = Integer.MAX_VALUE;
//        for(Integer i : frequncy.keySet()) {
//            if(frequncy.get(i) < min) {
//                min = frequncy.get(i);
//                MINF = i;
//            }
//        }


    }

    private void incrementF(int key) {
        int element = 1;
        if (frequncy.get(key) != null) {
            element = frequncy.get(key);
            frequncy.put(key, (element + 1));
            setMinPriority(key);
        } else {
            frequncy.put(key, 1);
            setMinPriority(-1);
        }


    }

    private void setMinPriority(int key) {
        int min = Integer.MAX_VALUE;
        for (Integer i : frequncy.keySet()) {
            if (frequncy.get(i) < min && i != key) {
                System.out.println("set min " + frequncy.get(i));
                min = frequncy.get(i);
                MINF = i;
            }
        }

    }


    private boolean isFull() {
        return frequencyMap.size() == SIZE;
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(3 /* capacity */);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.get(4);
        cache.get(3);
        cache.get(2);
        cache.get(1);
        cache.put(5, 5);
        cache.get(1);
        cache.get(2);
        cache.get(3);
        cache.get(4);
        cache.get(5);
    }
}
