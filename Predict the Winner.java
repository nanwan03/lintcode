public class Solution {
    /**
     * @param nums: nums an array of scores
     * @return: check if player 1 will win
     */
    public boolean PredictTheWinner(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return true;
        }
        int size = nums.length;
        int[] dp = new int[size];
        for (int start = size - 1; start >= 0; --start) {
            for (int end = start; end < size; ++end) {
                if (start == end) {
                    dp[end] = nums[end];
                } else {
                    dp[end] = Math.max(nums[start] - dp[end], nums[end] - dp[end - 1]);
                }
            }
        }
        return dp[size - 1] >= 0;
    }
}