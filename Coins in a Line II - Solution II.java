public class Solution {
    /*
     * @param : a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values.length <= 2) {
            return true;
        }
        return helper(values, 0, values.length - 1, new Integer[values.length]) >= 0;
    }
    private int helper(int[] values, int left, int right, Integer[] dp) {
        if (dp[left] != null) {
            return dp[left];
        }
        if (left > right) {
            return 0;
        } else if (left == right) {
            dp[left] = values[left];
        } else if (left + 1 == right) {
            dp[left] =  values[left] + values[left + 1];
        } else {
            dp[left] = Math.max(values[left] - helper(values, left + 1, right, dp), values[left] + values[left + 1] - helper(values, left + 2, right, dp));
        }
        return dp[left];
    }
};