public class Solution {
    /**
     * @param n a positive integer
     * @param primes the given prime list
     * @return the nth super ugly number
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        // Write your code here
        Queue<Long> heap = new PriorityQueue<Long>();
        heap.offer(1L);
        Set<Long> set = new HashSet<Long>();
        set.add(1L);
        while (--n > 0) {
            long val = heap.poll();
            for (int i : primes) {
                if (set.add(val * i)) {
                    heap.offer(val * i);
                }
            }
        }
        return heap.peek().intValue();
    }
}