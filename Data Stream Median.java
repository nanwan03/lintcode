public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    private Queue<Integer> minHeap = new PriorityQueue<Integer>();
    private Queue<Integer> maxHeap;
    public int[] medianII(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] rst = new int[nums.length];
        maxHeap = new PriorityQueue<Integer>(nums.length, Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            insertHeap(nums[i]);
            rst[i] = maxHeap.peek();
        }
        return rst;
    }
    private void insertHeap(int i) {
        if (maxHeap.isEmpty() || i < maxHeap.peek()) {
            maxHeap.offer(i);
        } else {
            minHeap.offer(i);
        }
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
    }
}
