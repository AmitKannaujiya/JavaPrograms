package algoMadeEasyBook;

import LinkList.LinkList;

public class LinkedListPractise {

    public static void main(String[] args) {
        LinkList first =new LinkList(2);
        first.next = new LinkList(3);
        first.next.next = new LinkList(4);


        LinkList second = new LinkList(1);
        LinkList third = second.next = new LinkList(5);
        first.next.next.next = third;
        first.next.next.next.next = new LinkList(6);
        first.next.next.next.next.next = new LinkList(7);
        printIntersectionOfLinkedList(first,second);

    }



    private static void printIntersectionOfLinkedList(LinkList first, LinkList second) {
        int fSize = first.length();
        int sSize = second.length();
        LinkList largest, smalest = null;
        int count = 0;
        if(fSize > sSize) {
            largest = first;
            smalest = second;
            count = fSize - sSize;
        } else {
            largest = first;
            smalest = second;
            count = fSize - sSize;
        }
        while (count > 0) {
            largest = largest.next;
            count --;
        }
        while (largest.next != null && smalest.next!=null ) {
            largest = largest.next;
            smalest =smalest.next;
            if(largest== smalest ){
                System.out.println("Comon node :" + largest.data);
                return;
            }
        }
        System.out.println("No Node");
    }
}
