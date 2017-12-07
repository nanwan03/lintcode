public class Solution {
    /**
     * @param nums: 4 cards
     * @return: whether they could get the value of 24
     */
    public boolean compute24(double[] nums) {
        // write your code here
    	if (nums == null || nums.length == 0) {
    		return false;
    	}
    	int size = nums.length;
    	return helper(nums, new boolean[size], size, 0, 1);
    }
    private boolean helper(double[] nums, boolean[] isused, int size, double div, double did) {
    	if (size == 0) {
    		return (int)div / did == 24;
    	}
    	for (int i = 0; i < isused.length; ++i) {
    		if (!isused[i]) {
    			double val = nums[i];
    			isused[i] = true;
    			boolean plus = helper(nums, isused, size - 1, div + val * did, did);
    			boolean min = helper(nums, isused, size - 1, div - val * did, did) || helper(nums, isused, size - 1, val * did - div, did);
    			boolean mul = helper(nums, isused, size - 1, (size == nums.length ? 1 : div) * val, did);
    			boolean divide = helper(nums, isused, size - 1, (size == nums.length ? 1 : div), did * val) ||
    								helper(nums, isused, size - 1, did * val, (size == nums.length ? 1 : div));
    			isused[i] = false;
    			if (plus || min || mul || divide) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
}