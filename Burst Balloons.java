public class Solution {
    /**
     * @param nums a list of integer
     * @return an integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] helper = new int[nums.length + 2];
        helper[0] = 1;
        helper[helper.length - 1] = 1;
        for (int i = 0; i < nums.length; ++i) {
            helper[i + 1] = nums[i];
        }
        int size = helper.length;
        int[][] dp = new int[size][size];
        for (int end = 1; end < size - 1; ++end) {
            for (int start = end; start > 0; --start) {
                for (int k = start; k <= end; ++k) {
                    dp[start][end] = Math.max(dp[start][end], dp[start][k - 1] + dp[k + 1][end] + helper[start -1] * helper[k] * helper[end + 1]);
                }
            }
        }
        return dp[1][size - 2];
    }
}
