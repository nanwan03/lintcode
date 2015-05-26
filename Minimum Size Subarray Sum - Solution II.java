public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	int[] aus = new int[nums.length + 1];
    	aus[0] = 0;
    	for (int i = 1; i < aus.length; i++) {
    		aus[i] = aus[i - 1] + nums[i - 1];
    	}
    	int rst = Integer.MAX_VALUE;
    	for (int i = 0; i < aus.length - 1; i++) {
    		int index = binarySearchLowerBound(aus, i + 1, aus.length - 1, aus[i] + s);
    		if (index != -1) {
    			rst = Math.min(rst, index - i);
    		}
    	}
    	return rst == Integer.MAX_VALUE ? 0 : rst;
    }
    public int binarySearchLowerBound(int[] nums, int left, int right, int target) {
    	while (left + 1 < right) {
    		int mid = left + (right - left) / 2;
    		if (nums[mid] >= target) {
    			right = mid;
    		} else {
    			left = mid + 1;
    		}
    	}
    	if (nums[left] >= target) {
    		return left;
    	} else if (nums[right] >= target) {
    		return right;
    	} else {
    		return -1;
    	}
    }
}
