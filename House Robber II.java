public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
    private int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int[] dp = new int[]{nums[start], Math.max(nums[start], nums[start + 1]), 0};
        for (int i = start + 2; i <= end; ++i) {
            dp[2] = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[1];
    }
}