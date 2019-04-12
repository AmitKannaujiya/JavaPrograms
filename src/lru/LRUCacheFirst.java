package lru;

import java.util.HashMap;

/**
 * Created by amit on 4/1/19.
 */
public class LRUCacheFirst {
    int capacity;
    DoublyLinkList<Integer> doublyLinkList;
    HashMap<Node<Integer>, Integer> hashMap;

    public LRUCacheFirst(int capacity) {
        this.capacity = capacity;
        doublyLinkList = new DoublyLinkList<>(capacity);
        hashMap = new HashMap<>();
    }


    public int get(int key) {
        Node node = doublyLinkList.find(key);
        if(node!=null) {
            if(hashMap.containsKey(node)) {
                System.out.println(hashMap.get(node));
                return hashMap.get(node);
            } else {
                System.out.println("Error for Key : "+ key);
            }
        }
        return -1;

    }

    public void put(int key, int value) {
        // invalidate the list

        // insert at the front of LinkList
        // update has map to store address of list against the key
        Node node = doublyLinkList.insert(key);
        if(node!=null) {
            hashMap.put(node, value);
            System.out.println(hashMap.get(node));
        } else {
            System.out.println("Error Not save key : "+ key);
        }

    }





}
