public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int longest = 1;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] >= nums[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    longest = Math.max(longest, dp[j]);
                }
            }
        }
        return longest;
    }
}

