public class Solution {
    /**
     * @param nums: the array
     * @return: the minimum times to flip digit
     */
    public int flipDigit(int[] nums) {
        // Write your code here
        if (nums.length <= 1) {
            return 0;
        }
        
        int size = nums.length;
        int[][] dp = new int[size + 1][2];
        dp[0][0] = dp[0][1] = 0;
        
        for (int i = 1; i <= size; ++i) {
            for (int j = 0; j <= 1; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                int tmp = j == nums[i - 1] ? 0 : 1;
                for (int k = 0; k <= 1; ++k) {
                    if (k == 0 && j == 1) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i - 1][k] + tmp, dp[i][j]);
                }
            }
        }
        return Math.min(dp[size][0], dp[size][1]);
    }
}