public class Solution {
    /*
     * @param : a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            return true;
        }
        int size = values.length;
        if (size <= 2) {
            return true;
        }
        int[] dp = new int[]{values[size - 2] + values[size - 1], values[size - 1]};
        for (int i = size - 3; i >= 0; --i) {
            int temp = Math.max(values[i] - dp[0], values[i] + values[i + 1] - dp[1]);
            dp[1] = dp[0];
            dp[0] = temp;
        }
        return dp[0] >= 0;
    }
};