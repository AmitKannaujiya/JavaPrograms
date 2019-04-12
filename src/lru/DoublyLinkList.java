package lru;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit on 4/1/19.
 */
public class DoublyLinkList<T> {
    int size = 0;
    Node node = null;
    int capacity;

    DoublyLinkList(int size) {
        this.capacity = size;
    }

    public Node insert(T key) {
        Node node1 = new Node(key);
        if(isEmpty()) {
            size++;
            this.node = node1;
        } else if (isFull()) {
            Node node2 = node1;
            while (node.front != null) {
                node = node.front;
            }
            node.front = node1;
            node1.back= node;
            while (node1.back!=null) {
                node1 = node1.back;
            }

            node1=node1.front;
            node1.back=null;
            size++;
            return  node2;

        } else {
            while (node.front != null) {
                node = node.front;
            }
            node.front = node1;
            node1.back= node;
        }

        return node1;
    }

    public Node find(T key) {
        if(isEmpty()) {
            return null;
        }else {
            Node node1 = null;
            while (node.front!=null){
                if(node.data.equals(key)) {
                    node1 = node;
                    node1.back.front = node1.front;
                    node1.front.back = node1;

                    while (node.front !=null) {
                        node=node.front;
                    }
                    node.front = node1;
                    node1.back=node;
                    node1.front=null;
                    break;
                }
                node = node.front;
            }
            return node1;
        }

    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}

class Node<T> {
    T data;
    Node front;
    Node back;

    Node(T data){
        this.data = data;
        this.front = null;
        this.back = null;
    }

    Node(T data, Node front, Node back) {
        this.data = data;
        this.front = front;
        this.back = back;
    }

}
