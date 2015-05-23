public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     * Memory Limit Exceed
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            return false;
        }
        int[] dp = new int[5];
        Arrays.fill(dp, 0);
        int sum = 0;
        for (int i = values.length - 1; i >= 0; i--) {
            sum += values[i];
            int a = i + 2 < values.length ? dp[(i + 2) % 5] : 0;
            int b = i + 3 < values.length ? dp[(i + 3) % 5] : 0;
            int c = i + 4 < values.length ? dp[(i + 4) % 5] : 0;
            dp[i % 5] = Math.max(values[i] + Math.min(a, b), 
                            values[i] + ((i + 1) < values.length ? values[i + 1] : 0) + Math.min(b, c));
        }
        return dp[0] > sum - dp[0];
    }
}
