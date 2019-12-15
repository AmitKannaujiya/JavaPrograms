package lru;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRUCache2 {
    HashMap<Integer, DLinkedList> map;
    DLinkedList head, tail ;
    int capacity ;
    int length = 0;
    public LRUCache2(int capacity) {
        this.map = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        DLinkedList temp = null;
        if(map.containsKey(key)) {
            temp = map.get(key);
            if(temp == head) {
                return temp.val;
            }
            if(temp == tail) {
                tail = temp.left;
                temp.left = null;
                tail.right = temp.left;

            } else {
                temp.left.right = temp.right;
                temp.right.left = temp.left;
                temp.left = null;
                temp.right = null;
            }

        } else {
            return -1;
        }
        insert(temp);
        return temp.val;
    }

    public void put(int key, int value) {
        DLinkedList temp = null;
        if(map.containsKey(key)) {
            temp = map.get(key);
            temp.val = value;
            if(temp == head) {
                return;
            }
            if(temp == tail) {
                tail = temp.left;
                temp.left = null;
                tail.right = null;

            } else {
                temp.left.right = temp.right;
                temp.right.left = temp.left;
                temp.left = null;
                temp.right = null;
            }
        }
        if(temp == null) {
            temp = new DLinkedList(value);
        }
        if(isFull()) {
            remove();
        }
        insert(temp);
        this.length++;
        map.put(key, temp);

    }

    private void remove() {
        DLinkedList temp = this.tail;
        this.tail = temp.left;
        this.tail.right = null;
        map.remove(temp.val);
        this.length--;
        temp = null;
    }
    private void insert(DLinkedList node) {
        if(this.head == null) {
            this.head = node;
            this.tail = node;
            return;
        }
        node.right = head;
        head.left = node;
        node.left = null;
        head = node;
    }

    private boolean isFull() {
        return this.capacity == this.length;
    }
}

class DLinkedList {
    int val;
    DLinkedList left;
    DLinkedList right;
    public DLinkedList(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
