package lru;

/**
 * Created by amit on 6/1/19.
 */
public class LRUCacheTest {
    public static void main(String[] args) {
//        LRUCacheFirst cache = new LRUCacheFirst(2 /* capacity */);
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4

        // Not worked properly
        LRUCache2 c = new LRUCache2(2);
        c.put(1, 1);
        c.put(2, 2);
        System.out.println(c.get(1));       // returns 1
        c.put(3, 3);    // evicts key 2
        System.out.println(c.get(2));   // returns -1 (not found)
        c.put(4, 4);    // evicts key 1
        System.out.println(c.get(1)); // returns -1 (not found)
        System.out.println(c.get(3));   // returns 3
        System.out.println(c.get(4));      // returns 4
    }
}
