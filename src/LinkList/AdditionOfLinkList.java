package LinkList;

/**
 * Created by amit on 21/5/19.
 */
public class AdditionOfLinkList {

    public static void main(String[] args) {
        // 4->3->2
        LinkList list = new LinkList(4);
        list.next = new LinkList(3);
        list.next.next = new LinkList(2);
        //list.next.next.next = new LinkList(1);
        // 4->2->8
        LinkList list2 = new LinkList(4);
        list2.next = new LinkList(2);
        list2.next.next = new LinkList(8);
       // list2.next.next.next = new LinkList(4);

        AdditionOfLinkList obj = new AdditionOfLinkList();
        //  8->6->0
        LinkList result = obj.sumTwoLinkList(list, list2);
        obj.printList(list);
        obj.printList(list2);
        obj.printList(result);

    }


    public void printList(LinkList linkList) {
        LinkList temp = linkList;
        System.out.println("Printing list");
        while (temp!=null) {
            System.out.print(temp.data + " -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

    LinkList sumTwoLinkList(LinkList first, LinkList second) {
        LinkList result = null;
        LinkList previous = null, temp=null;
        int carry = 0;
        while(first !=null || second !=null) {
            int sum = carry + (first!=null ? first.data : 0) + (second !=null ? second.data : 0);
            carry = sum >= 10 ? 1: 0;
            sum = sum % 10;
            temp = new LinkList(sum);

            if(result == null) {
                result = temp;
            } else {
                previous.next = temp;
            }
            previous = temp;
            if(first!= null) {
                first = first.next;
            }

            if(second!=null) {
                second = second.next;
            }
        }

        if(carry > 0) {
            previous.next = new LinkList(carry);
        }
        return result;
    }
}
