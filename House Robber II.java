public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        // write your code here
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robber1(nums, 0, nums.length - 2), robber1(nums, 1, nums.length - 1));
    }
    private int robber1(int[] nums, int start, int end) {
    	if (start == end) {
    		return nums[end];
    	}
        if (start + 1 == end) {
            return Math.max(nums[start], nums[end]);
        }
        int maxPrev = Math.max(nums[start], nums[start + 1]);
        int max2Before = nums[start];
        for (int i = start + 2; i <= end; i++) {
            int tempMax = Math.max(max2Before + nums[i], maxPrev);
            max2Before = maxPrev;
            maxPrev = tempMax;
        }
        return maxPrev;
    }
}