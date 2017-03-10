public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        int[][] dp = new int[nums.length + 1][k + 1];
        for (int i = 0; i <= nums.length; i++) {
        	dp[i][0] = 0;
        	for (int j = 1; j <= k; j++) {
        		dp[i][j] = Integer.MIN_VALUE;
        	}
        }
        for (int i = 1; i <= nums.length; i++) {
        	for (int j = 1; j <= Math.min(i, k); j++) {
        		int temp = 0;
        		dp[i][j] = dp[i - 1][j];
        		for (int p = i; p >= j; p--) {
        			temp = Math.max(temp, 0) + nums[p - 1];
        			dp[i][j] = Math.max(dp[i][j], dp[p - 1][j - 1] + temp);
        		}
        	}
        }
        return dp[nums.length][k];
    }
}
