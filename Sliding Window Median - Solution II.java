public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    private Queue<Integer> minH = new PriorityQueue<Integer>();
    private Queue<Integer> maxH = new PriorityQueue<Integer>(1, Collections.reverseOrder());
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (i > k - 1) {
                int top = nums[i - k];
                if (top <= maxH.peek()) {
                    maxH.remove(top);
                    if (maxH.size() == 0 && minH.size() != 0) {
                        maxH.offer(minH.poll());
                    }
                } else {
                    minH.remove(top);
                }
            }
            if (maxH.isEmpty() || nums[i] <= maxH.peek()) {
                maxH.offer(nums[i]);
            } else {
                minH.offer(nums[i]);
            }
            if (minH.size() > maxH.size()) {
                maxH.offer(minH.poll());
            }
            if (maxH.size() > minH.size() + 1) {
                minH.offer(maxH.poll());
            }
            if (i >= k - 1) {
                rst.add(maxH.peek());
            }
        }
        return rst;
    }
}
