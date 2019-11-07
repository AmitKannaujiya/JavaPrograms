package lru;

import java.util.*;

/**
 * Created by amit on 14/7/18.
 */
public class LRUCacche3 {

    HashMap<Integer, Integer> frequencyMap;
    //int MINF = -1;

    //HashMap<Integer, Integer> frequncy;
    ArrayList<Integer> priority;
    int index = 0;

    int SIZE;

    public LRUCacche3(int capacity) {
        this.frequencyMap = new LinkedHashMap<>(capacity);
        //this.frequncy = new LinkedHashMap<>();
        this.priority = new ArrayList<>(capacity + 1);
        this.SIZE = capacity;
    }

    public int get(int key) {

        if (frequencyMap.containsKey(key)) {
            //incrementF(key);
            incrementPriority(key);
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
        if (isFull()) {
            // Evict element
            // 1 ) Remove LRU element
            //  2 ) if same element is present at multiple places
            //  3 ) evict LRU element only, who's frequency is low
            decrementF(key, value);
        } else {
            // incrementF(key);
            incrementPriority(key);
            frequencyMap.put(key, value);
        }
    }

    private void decrementF(int key, int value) {
        // frequencyMap.remove(MINF);
        System.out.println("removing : " + priority.get(0));
        frequencyMap.remove(priority.get(0));
        //frequncy.remove(MINF);
        //decrementPriority();
        frequencyMap.put(key, value);
        System.out.println("Map : " + frequencyMap);
        //incrementF(key);
        incrementPriority(key);
    }

    private void incrementPriority(int key) {
        if (priority.size() == SIZE) {
            priority.remove(0);
        }
        priority.add(key);
        System.out.println("inc priority queue " + priority);
    }

    private void decrementPriority() {

        if (priority.size() >= 1) {
            index--;
            priority.remove(0);
            System.out.println("1 dec priority queue " + priority);
//            for(int i =0; i<index && i<priority.size(); i++) {
//                priority.add(i, priority.get(i+1));
//            }
        }
        // System.out.println("2 dec priority queue " + priority);


    }
//
//    private void incrementF(int key) {
//        int element = 1;
//        if(frequncy.get(key)!=null) {
//            element = frequncy.get(key);
//            frequncy.put(key, (element+1));
//            setMinPriority(key);
//        } else {
//            frequncy.put(key, 1);
//            setMinPriority(-1);
//        }
//
//
//    }

//    private void setMinPriority(int key) {
//        int min = Integer.MAX_VALUE;
//        for(Integer i : frequncy.keySet()) {
//            if(frequncy.get(i) < min && i != key) {
//                min = frequncy.get(i);
//                MINF = i;
//            }
//        }
//
//    }


    private boolean isFull() {
        return frequencyMap.size() == SIZE;
    }

    public static void main(String[] args) {
//        LRUCacche3 cache = new LRUCacche3( 3 /* capacity */ );
//        cache.put(1,1);
//        cache.put(2,2);
//        cache.put(3,3);
//        cache.put(4,4);
//        cache.get(4);
//        cache.get(3);
//        cache.get(2);
//        cache.get(1);
//        cache.put(5,5);
//        cache.get(1);
//        cache.get(2);
//        cache.get(3);
//        cache.get(4);
//        cache.get(5);

//        ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
//[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
// my [null,null,null,1,null,2,3,null,-1,3,4]
//   expected     [null,null,null,1,null,-1,3,null,-1,3,4]
        LRUCacche3 cache = new LRUCacche3(2);  /* ca */
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.get(3);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);


    }
}
