package algoMadeEasyBook;

public class SortedLinkListInsert {

// Java Program to insert in a sorted list

    Node head; // head of list

    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    /* function to insert a new_node in a list. */
    void sortedInsert(Node new_node) {
        Node current = head;
        Node prev = null;

        if (head == null) {
            head = new_node;
            return;
        }

        while (current != null) {
            if (current.data < new_node.data) {
                prev = current;
                current = current.next;
            } else {
               break;
            }

        }
        if (prev != null) {
            prev.next = new_node;
            new_node.next = current;
            return;
        } else {
            new_node.next = current;
            head = new_node;
            return;
        }
    }

//        while(current!=null) {
//            if(current->next < new_node) {
//                prev= current;
//                current=current->next;
//            } else {
//                if(prev !=null) {
//                    prev->next = new_node;
//                    new_node->next = current;
//                    return;
//                } else {
//                    new_node->next = current;
//                    head= new_node;
//                    return;
//                }
//            }
//        }
//    }

    /*Utility functions*/

    /* Function to create a node */
    Node newNode(int data)
    {
        Node x = new Node(data);
        return x;
    }

    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    /* Driver function to test above methods */
    public static void main(String args[])
    {
        SortedLinkListInsert llist = new SortedLinkListInsert();
        Node new_node;
        new_node = llist.newNode(5);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(10);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(7);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(3);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(1);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(9);
        llist.sortedInsert(new_node);
        System.out.println("Created Linked List");
        llist.printList();
    }
}