import java.util.*;

class Solution {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        // write your code here
        if (k == 0) {
            return 0;
        }
        Queue<Long> heap = new PriorityQueue<Long>();
        heap.offer((long)3);
        heap.offer((long)5);
        heap.offer((long)7);
        Set<Long> set = new HashSet<Long>();
        set.add((long)3);
        set.add((long)5);
        set.add((long)7);
        while (k > 1) {
            long cur = heap.poll();
            if (set.add(cur * 3)) {
                heap.offer(cur * 3);
            }
            if (set.add(cur * 5)) {
                heap.offer(cur * 5);
            } 
            if (set.add(cur * 7)) {
                heap.offer(cur * 7);
            }
            k--;
        }
        return heap.peek();
    }
};

