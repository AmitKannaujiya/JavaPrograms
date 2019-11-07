package lru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by amit on 14/7/18.
 */
public class LRUCache4 {
    HashMap<Integer, Integer> frequencyMap;
    ArrayList<Integer> priority;
    int index = 0;

    int SIZE;

    public LRUCache4(int capacity) {
        this.frequencyMap = new LinkedHashMap<>(capacity);
        //this.frequncy = new LinkedHashMap<>();
        this.priority = new ArrayList<>(capacity + 1);
        this.SIZE = capacity;
    }
}
