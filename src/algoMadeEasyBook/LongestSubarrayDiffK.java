package algoMadeEasyBook;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LongestSubarrayDiffK {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,6};
        LongestSubarrayDiffK obj = new LongestSubarrayDiffK();
        System.out.println(obj.computeLongestSubarray(array,3));
        System.out.println(obj.getLonestSubarrayDiffK(array,3));

    }
    public int getLonestSubarrayDiffK(int[] array,int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)-> (a-b));
        int start =0;
        int end= 0;
        int i =0;
        int res = 0;
        while (end < array.length){
            int currEl = array[end];
            maxHeap.add(end);
            minHeap.add(end);
            // Index of maximum of current subarray
            int maxOfSub = array[maxHeap.peek()];

            // Index of minimum of current subarray
            int minOfSub = array[minHeap.peek()];
            if (maxOfSub - minOfSub <= k) {
                res++;
            } else {
                start++;
                while (minHeap.size() > 0 &&
                        minHeap.peek() < start)
                    minHeap.remove();

                while (maxHeap.size() > 0 &&
                        maxHeap.peek() < start)
                    maxHeap.remove();
            }
            end++;
        }
        return res;
    }

    public int computeLongestSubarray(int arr[],
                                             int k)
    {
        // Stores the maximum length subarray so far
        int maxLength = 0;

        Deque<Integer> maxHeap = new LinkedList<>();
        Deque<Integer> minHeap = new LinkedList<>();

        // Marks to the beginning and end
        // pointer for current subarray
        int beg = 0, end = 0;

        while (end < arr.length) {

            // Stores the current element being
            // added to the subarray
            int currEl = arr[end];

            // Remove indices of all elements smaller
            // than or equal to current from maxHeap
            while (maxHeap.size() > 0 &&
                    arr[maxHeap.peekLast()] <= currEl)
                maxHeap.removeLast();

            // Add current element's index to maxHeap
            maxHeap.addLast(end);

            // Remove indices of all elements larger
            // than or equal to current from minHeap
            while (minHeap.size() > 0 &&
                    arr[minHeap.peekLast()] >= currEl)
                minHeap.removeLast();

            // Add current element's index to minHeap
            minHeap.addLast(end);

            // Index of maximum of current subarray
            int maxOfSub = arr[maxHeap.peekFirst()];

            // Index of minimum of current subarray
            int minOfSub = arr[minHeap.peekFirst()];

            // check if the largest possible difference
            // between a pair of elements <= k
            if (maxOfSub - minOfSub <= k) {
                // Length of current subarray
                int currLength = end - beg + 1;

                // Update maxLength
                if (maxLength < currLength)
                    maxLength = currLength;
            }

            else {
                // If current subarray doesn't satisfy
                // the condition then remove the starting
                // element from subarray that satisfy
                // increment the beginning pointer
                beg++;

                // Remove elements from heaps that
                // are not in the subarray anymore
                while (minHeap.size() > 0 &&
                        minHeap.peekFirst() < beg)
                    minHeap.removeFirst();

                while (maxHeap.size() > 0 &&
                        maxHeap.peekFirst() < beg)
                    maxHeap.removeFirst();
            }

            end++;
        }

        // Return the final answer
        return maxLength;
    }


}
