package LinkList;

/**
 * Created by amit on 13/4/19.
 */
public class LinkListTest {
    public static void main(String[] args) {

        LinkList list = new LinkList(4);
        list.next = new LinkList(3);
        list.next.next = new LinkList(2);
        list.next.next.next = new LinkList(1);
        LinkListTest obj = new LinkListTest();
        obj.printList(list);
        LinkList revList = obj.reverseList(list);
        obj.printList(revList);
    }

    public void printList(LinkList linkList) {
        LinkList temp = linkList;
        System.out.println("Printing list");
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public LinkList reverseList(LinkList list) {
        LinkList current = list, next = list.next, previous = null;
        if (current.next == null) {
            return current;
        }
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        }
        //previous.next = list;
        return previous;
    }

}
