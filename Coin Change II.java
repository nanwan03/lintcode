public class Solution {
    /**
     * @param amount: a total amount of money amount
     * @param coins: the denomination of each coin
     * @return: the number of combinations that make up the amount
     */
    public int change(int amount, int[] coins) {
        // write your code here
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; ++i) {
            for (int j = coins[i]; j <= amount; ++j) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}