package techDosePlan;

import java.util.Arrays;

public class KthSmallestNumberInArrayARRAY2 {
    public static void main(String[] args) {
        int a[] = new int[]{7, 10, 4, 3, 20, 15};
        int k = 2;
        KthSmallestNumberInArrayARRAY2 obj = new KthSmallestNumberInArrayARRAY2();
        //MinHeap minHeap = obj.buildHeap(a);
        MinHeap minHeap = new MinHeap(a);
        minHeap.buildHeap();
        int min = 0;
        for (int i = 0; i < k; i++) {
            min = minHeap.extractMin();
        }
        System.out.println("Kth Min " + min);
    }

    MinHeap buildHeap(int[] a) {
        MinHeap minHeap = new MinHeap(a.length);
        for (int i = 0; i < a.length; i++) {
            minHeap.addElement(a[i]);
        }
        return minHeap;
    }


}

class MinHeap {
    int capacity;
    int [] array = null;
    int size = -1;
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public MinHeap(int[] array) {
        this.capacity = array.length;
        this.array = array;
        this.size = array.length -1;
    }
    
    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    int parent(int index) {
        return index / 2;
    }

    void buildHeap() {
        for(int i = this.capacity/2; i >= 0; i--) {
            heapify(i);
        }
    }

    void heapify(int index) {
        int smallest = index;
        int left = this.left(index);
        if(left <= size && this.array[left] < this.array[smallest] ) {
            smallest = left;
        }
        int right = this.right(index);
        if(right <= size && this.array[right] < this.array[smallest]) {
            smallest = right;
        }
        if(smallest != index) {
            swap(smallest, index);
            heapify(smallest);
        }
    }

    void swap(int i , int j) {
        int temp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = temp;
    }

    void addElement(int ele) {
        ensureCapacity();
        this.array[++size] = ele;
        if(size != 0) {
            heapifyUp();
        }
    }
    int extractMin() {
        if(size == -1) throw new ArrayIndexOutOfBoundsException("Illigal operation");
        int item = this.array[0];
        this.array[0]= this.array[size];
        size--;
        if(size != 0) {
            heapify(0);
        }
        return item;
    }

    void ensureCapacity() {
        if(size == capacity-1) {
            this.array = Arrays.copyOf(this.array, capacity * 2);
            this.capacity *= 2; 
        }
    }

    int peek() {
        if(size == -1) throw new ArrayIndexOutOfBoundsException("Illigal operation");
        return this.array[0];
    }

    void heapifyUp() {
        int index = size;
        int parent = parent(index);
        while(parent > 0 && this.array[parent] > this.array[index]) {
            swap(parent, index);
            index = parent;
        }
    }
}