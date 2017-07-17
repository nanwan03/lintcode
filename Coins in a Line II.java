public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            return false;
        }
        if (values.length <= 2) {
            return true;
        }
        int size = values.length;
        int[] dp = new int[]{values[size - 3] + values[size - 2], values[size - 2] + values[size - 1], values[size - 1], 0};
        for (int i = size - 4; i >= 0; --i) {
            int temp = values[i] + Math.min(dp[1], dp[2]);
            temp = Math.max(temp, values[i] + values[i + 1] + Math.min(dp[2], dp[3]));
            dp[3] = dp[2];
            dp[2] = dp[1];
            dp[1] = dp[0];
            dp[0] = temp;
        }
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return dp[0] > sum - dp[0];
    }
}