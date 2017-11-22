public class Solution {
    /*
     * @param nums: an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
    public int backPackV(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i : nums) {
            for (int j = target; j >= i; --j) {
                dp[j] += dp[j - i];
            }
        }
        return dp[target];
    }
}