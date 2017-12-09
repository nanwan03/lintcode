public class Solution {
    /*
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    public int coinChange(int[] coins, int amount) {
        // write your code here
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}