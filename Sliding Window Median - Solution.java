public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    private Queue<Integer> minHeap;
	private Queue<Integer> maxHeap;
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        minHeap = new PriorityQueue<Integer>(k);
        maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
        	if (i > k - 1) {
        		int top = nums[i - k];
        		if (top <= maxHeap.peek()) {
        			maxHeap.remove(top);
        			if (maxHeap.size() == 0 && minHeap.size() > 0) {
        				maxHeap.offer(minHeap.poll());
        			}
        		} else {
        			minHeap.remove(top);
        		}
        	}
        	if (maxHeap.size() == 0 || nums[i] <= maxHeap.peek()) {
        		maxHeap.offer(nums[i]);
        	} else {
        		if (nums[i] > maxHeap.peek()) {
        			minHeap.offer(nums[i]);
        		}
        	}
        	if (minHeap.size() > maxHeap.size()) {
        		maxHeap.offer(minHeap.poll());
        	}
        	if (maxHeap.size() > minHeap.size() + 1) {
        		minHeap.offer(maxHeap.poll());
        	}
        	if (i >= k - 1) {
        		rst.add(maxHeap.peek());
        	}
        }
        return rst;
    }
}

