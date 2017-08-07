public class Solution {
    /**
     * @param n an integer
     * @return how much money you need to have to guarantee a win
     */
    public int getMoneyAmount(int n) {
        // Write your code here
        int[][] dp = new int[n + 1][n + 1];
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - (l - 1); i++) {
                int j = i + (l - 1);
                dp[i][j] = Integer.MAX_VALUE;
                for (int g = i; g <= j; g++) {
                    int cost;
                    if (g == n) {
                        cost = dp[i][g - 1] + g;
                    } else {
                        cost = g + Math.max(dp[i][g - 1], dp[g + 1][j]);
                    }
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[1][n];
    }
}