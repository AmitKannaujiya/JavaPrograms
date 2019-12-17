package algoMadeEasyBook;

public class LastStoneLeetCode {
    public static void main(String[] args) {
        LastStoneLeetCode obj = new LastStoneLeetCode();
        obj.solveLastStoneProblem();
    }

    private void solveLastStoneProblem() {
        int[] stones = new int[]{2,7,4,1,8,1, 6, 15};

        Heap maxHeap = new Heap(stones);
        maxHeap.buildHeap();
        while(maxHeap.getSize() > 1) {
            int first = maxHeap.extractMax();
            int second = maxHeap.extractMax();
            int diff = first - second;
            if(diff > 0) {
                maxHeap.insert(diff);
            }
        }

        maxHeap.printContents();

    }

    class Heap {
        int[] array = null;
        int capacity;
        public Heap(int[] array) {
            this.array = array;
            this.capacity = array.length;
        }
        int left(int i) {
            return 2*i+1;
        }
        int right(int i) {
            return 2*i + 2;
        }
        public void heapify(int i) {

            int left = left(i);
            int right= right(i);
            int largest = i;
            if(left < capacity && array[left] > array[largest]) {
                largest = left;
            }
            if(right < capacity && array[right] > array[largest]) {
                largest = right;
            }
            if(i != largest) {
                swap(i, largest);
                heapify(largest);
            }
        }

        public void swap(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        public void buildHeap() {

            for(int i=capacity/2-1; i>=0; i--) {
                heapify(i);
            }
        }

        public int extractMax() {
            int max = array[0];
            array[0] = array[capacity-1];
            this.capacity--;
            heapify(0);
            return max;
        }

        public void insert(int key) {
            capacity++;
            array[capacity-1] = key;
            //swap(0, capacity-1);
            //heapify(0);
            buildHeap();
        }

        public int getSize() {
            return this.capacity;
        }

        public void printContents() {
            for (int i=0; i<=capacity-1; i++) {
                System.out.println(array[i]);
            }

            System.out.println("Amit ");
            for (int i: array) {
                System.out.println(i);
            }
        }
    }
}
