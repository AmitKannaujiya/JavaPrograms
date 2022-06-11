package algoMadeEasyBook;

import LinkList.LinkList;

public class LinkedListPractise {

    public static void main(String[] args) {
        LinkList first = new LinkList(2);
        first.next = new LinkList(3);
        first.next.next = new LinkList(4);


        LinkList second = new LinkList(1);
        LinkList third = second.next = new LinkList(5);
        first.next.next.next = third;
        first.next.next.next.next = new LinkList(6);
        first.next.next.next.next.next = new LinkList(7);
        printIntersectionOfLinkedList(first, second);


        LinkList newList =  new LinkList(1);
        newList.next = new LinkList(2);
        newList.next.next = new LinkList(3);
        newList.next.next.next = new LinkList(4);
        newList.next.next.next.next = new LinkList(5);
        newList.next.next.next.next.next = new LinkList(6);
        pairwiseSwap(newList);

    }


    public static LinkList pairwiseSwap(LinkList head)
    {
        LinkList start =  head;
        LinkList cur = head;
        LinkList prev = null;
        int count = 2;
        while(start !=null && start.next !=null) {
            int temp =  start.data;
            start.data = start.next.data;
            start.next.data = temp;
            start = start.next.next;
        }
        return head;
    }

    private static void printIntersectionOfLinkedList(LinkList first, LinkList second) {
        int fSize = first.length();
        int sSize = second.length();
        LinkList largest, smalest = null;
        int count = 0;
        if (fSize > sSize) {
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
            count--;
        }
        while (largest.next != null && smalest.next != null) {
            largest = largest.next;
            smalest = smalest.next;
            if (largest == smalest) {
                System.out.println("Comon node :" + largest.data);
                return;
            }
        }
        System.out.println("No Node");
    }

    public static LinkList reverse(LinkList list) {
        LinkList prev =null, next = null, current = list;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static LinkList reverseNMList(LinkList list, int n,int m) {
        LinkList prev=null, next = null, current = list;
        while (current.next !=null) {
            if(current.data == n) {
                break;
            }
            prev = current;
            current = current.next;
        }
        while (current.next !=null) {
            next = current.next;
            if(current.data == m) {
                break;
            }
            current = next;
        }
        LinkList prev1=null, next1 = null, current1 = null;
        if(prev == null){
            current1 = list;
        } else {
            current1 = prev.next;
        }
        while (current1.next != next) {
            next1 = current1.next;
            current1.next = prev1;
            prev1= current1;
            current1 = next1;
        }
        prev.next = prev1;
        return list;
    }
}
