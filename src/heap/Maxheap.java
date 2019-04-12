package heap;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by amit on 2/4/19.
 */
public class Maxheap {
    int [] heap;
    int size;
    int maxSize;

    public Maxheap(int maxSize) {
        this.heap = new int[maxSize+1];
        this.size = 0;
        this.maxSize = maxSize;
        this.heap[0] = Integer.MAX_VALUE;
    }

    public int parent(int pos) {
        return pos/2;
    }

    public int left(int pos) {
        return 2* pos;
    }

    public int right(int pos) {
        return 2* pos + 1;
    }

    public boolean isLeaf(int pos) {
        if(pos >= size/2 && pos <= size) {
            return  true;
        }
        return false;
    }

    private void  swap(int pos1, int pos2) {
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    public void maxHeapify(int pos) {
        if(isLeaf(pos)) {
            return;
        }

        if(heap[left(pos)] > heap[pos] || heap[right(pos)] > heap[pos]) {
            if(heap[left(pos)] > heap[right(pos)]) {
                swap(left(pos), pos);
                maxHeapify(left(pos));
            } else {
                swap(right(pos), pos);
                maxHeapify(right(pos));
            }
        }
    }

    public void insert(int data) {
        heap[++size] = data;
        int current = size;
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " +
                    heap[2 * i] + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }

    public int extractmax() {
        int popped = heap[1];
        heap[1] = heap[size--];
        maxHeapify(1);
        return popped;
    }



    public static void main(String[] args) {

        System.out.println("The Max Heap is ");
        Maxheap maxHeap = new Maxheap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();
        System.out.println("The max val is " + maxHeap.extractmax());
        maxHeap.print();

        //////////

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        pQueue.add(10);
        pQueue.add(30);
        pQueue.add(20);
        pQueue.add(400);

        // Printing the most priority element
        System.out.println("Head value using peek function:" +
                pQueue.peek());

// Printing all elements
        System.out.println("The queue elements:");

        Iterator iterator = pQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Removing the top priority element (or head) and
        // printing the modified pQueue using poll()
        pQueue.poll();
        System.out.println("After removing an element "
                + "with poll function:");
        Iterator<Integer> itr2 = pQueue.iterator();
        while (itr2.hasNext())
            System.out.println(itr2.next());

        // Removing Java using remove()
        pQueue.remove(30);
        System.out.println("after removing Java with"
                + " remove function:");
        Iterator<Integer> itr3 = pQueue.iterator();
        while (itr3.hasNext())
            System.out.println(itr3.next());

        // Check if an element is present using contains()

        boolean b = pQueue.contains(20);
        System.out.println("Priority queue contains 20 "
                + "or not?: " + b);

        // Getting objects from the queue using toArray()
        // in an array and print the array
        Object[] arr = pQueue.toArray();
        System.out.println("Value in array: ");
        for (int i = 0; i < arr.length; i++)
            System.out.println("Value: " + arr[i].toString());

    }
}
