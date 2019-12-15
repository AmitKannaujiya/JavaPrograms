package lru;
import java.util.HashMap;

public class LeetCodeLRU{
    int capacity;
    DLink head;
    DLink end;
    HashMap<Integer, DLink> map;

    public LeetCodeLRU(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            DLink link = map.get(key);
            remove(link);
            setHead(link);
            return link.value;
        }

        return -1;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            DLink old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            DLink link = new DLink(key,value);
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

    private void setHead(DLink link) {
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
    private void remove(DLink link) {
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

class DLink {
    int key;
    int value;
    DLink left;
    DLink right;

    public DLink(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
