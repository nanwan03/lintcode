public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    private TreeMap<Integer, Integer> minHeap;
	private TreeMap<Integer, Integer> maxHeap;
	private int addElement(TreeMap<Integer, Integer> heap, int element, int size) {
		size++;
		if (heap.containsKey(element)) {
			heap.put(element, heap.get(element) + 1);
		} else {
			heap.put(element, 1);
		}
		return size;
	}
	private int removeElement(TreeMap<Integer, Integer> heap, int element, int size) {
		size--;
		if (heap.containsKey(element)) {
			if (heap.get(element) == 1) {
				heap.remove(element);
			} else {
				heap.put(element, heap.get(element) - 1);
			}
		}
		return size;
	}
    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        List<Integer> rst = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        minHeap = new TreeMap<Integer, Integer>();
        maxHeap = new TreeMap<Integer, Integer>();
        int minHeapSize = 0;
        int maxHeapSize = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (i > k - 1) {
        		int top = nums[i - k];
        		if (top <= maxHeap.lastKey()) {
        			maxHeapSize = removeElement(maxHeap, top, maxHeapSize);
        			if (maxHeapSize == 0 && minHeapSize > 0) {
        				int minHeapFirst = minHeap.firstKey();
        				minHeapSize = removeElement(minHeap, minHeapFirst, minHeapSize);
        				maxHeapSize = addElement(maxHeap, minHeapFirst, maxHeapSize);
        			}
        		} else {
        			minHeapSize = removeElement(minHeap, top, minHeapSize);
        		}
        	}
        	if (maxHeapSize == 0 || nums[i] <= maxHeap.lastKey()) {
        		maxHeapSize = addElement(maxHeap, nums[i], maxHeapSize);
        	} else {
        		if (nums[i] > maxHeap.lastKey()) {
        			minHeapSize = addElement(minHeap, nums[i], minHeapSize);
        		}
        	}
        	if (minHeapSize > maxHeapSize) {
        		int minHeapFirst = minHeap.firstKey();
        		minHeapSize = removeElement(minHeap, minHeapFirst, minHeapSize);
				maxHeapSize = addElement(maxHeap, minHeapFirst, maxHeapSize);
        	}
        	if (maxHeapSize > minHeapSize + 1) {
        		int maxHeapLast = maxHeap.lastKey();
        		maxHeapSize = removeElement(maxHeap, maxHeapLast, maxHeapSize);
        		minHeapSize = addElement(minHeap, maxHeapLast, minHeapSize);
        	}
        	if (i >= k - 1) {
        		rst.add(maxHeap.lastKey());
        	}
        }
        return rst;
    }
}

