package lru;

import java.util.HashMap;

/**
 * Created by amit on 7/1/19.
 */
public class DoublyLnkLst {
    int capacity;
    Link head;
    Link end;
    HashMap<Integer, Link> map;

    public DoublyLnkLst(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }
    public int get(int key) {
        if(map.containsKey(key)) {
            Link link = map.get(key);
            remove(link);
            setHead(link);
            return link.value;
        }

        return -1;
    }

    public void put(int key, int value){
        if (map.containsKey(key)) {
            Link old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Link link = new Link(key,value);
            if(map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(link);
            } else {
                setHead(link);
            }
            map.put(key, link);
        }
    }

    private void setHead(Link link) {
        link.right = head;
        link.left = null;
        if (head!=null) {
            head.left = link;
        }
        head=link;
        if(end==null){
            end=head;
        }
    }
    private void remove(Link link) {
        if(link.left!=null) {
            link.left.right = link.right;
        }else {
            head = link.right;
        }

        if(link.right!=null){
            link.right.left = link.left;
        } else {
            end = link.left;
        }
    }
}

class Link {
    int key;
    int value;
    Link left;
    Link right;

    public Link(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
