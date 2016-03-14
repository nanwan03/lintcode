public class Solution {
    /**
     * @param nums a list of integer
     * @return an integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        // Write your code here
         int[] helper = new int[nums.length + 2];
        helper[0] = 1;
        helper[helper.length - 1] = 1;
        for (int i = 0; i < nums.length; ++i) {
            helper[i + 1] = nums[i];
        }
        
        int[][] dp = new int[helper.length][helper.length];
        for (int len = 1; len <= nums.length; ++len) {
            for (int start = 1; start <= nums.length - len + 1; ++start) {
                int end = start + len - 1;
                int rst = 0;
                for (int cur = start; cur <= end; ++cur) {
                    int coins = dp[start][cur - 1] + dp[cur + 1][end];
                    coins += helper[start - 1] * helper[cur] * helper[end + 1];
                    rst = Math.max(rst, coins);
                }
                dp[start][end] = rst;
            }
        }
        return dp[1][nums.length];
    }
}
