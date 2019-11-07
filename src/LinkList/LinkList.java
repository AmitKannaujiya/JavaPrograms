package LinkList;

/**
 * Created by amit on 13/4/19.
 */
public class LinkList {
    public int data;
    public LinkList next;

    public LinkList(int data) {
        this.data = data;
        this.next = null;
    }

    public int length() {
        int length = 0;
        LinkList temp = this;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }
}
