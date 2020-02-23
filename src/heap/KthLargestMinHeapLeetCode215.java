package heap;

import java.util.PriorityQueue;

public class KthLargestMinHeapLeetCode215 {
    public static void main(String[] args) {

        int [] array = new int[]{3,2,1,5,6,4};
        int k = 3;
        KthLargestMinHeapLeetCode215 obj = new KthLargestMinHeapLeetCode215();
        System.out.println(obj.getKthLargest(array, k));
    }

    private int getKthLargest(int[] array, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int no:array) {
            if(queue.size()<k) {
                queue.add(no);
            } else if(queue.peek() < no) {
                queue.poll();
                queue.add(no);
            } else {
                continue;
            }
        }
        return queue.peek();
    }
}
