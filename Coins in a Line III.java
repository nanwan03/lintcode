public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values.length % 2 == 0) {
            return evenCoins(values);
        }
        int sum = 0;
        for (int i : values) {
            sum += i;
        }
        int[][] dp = new int[values.length][3];
        for (int i = 1; i <= values.length; i++) {
            for (int j = 0; j + i - 1 < values.length; j++) {
                int a = j + 2 <= values.length - 1 && i - 2 >= 0 ? dp[j + 2][(i - 2) % 3] : 0;
                int b = j + 1 <= values.length - 1 && i - 2 >= 0 ? dp[j + 1][(i - 2) % 3] : 0;
                int c = i - 2 >= 0 ? dp[j][(i - 2) % 3] : 0;
                dp[j][i % 3] = Math.max(values[j] + Math.min(a, b), values[j + i - 1] + Math.min(b, c));
            }
        }
        return dp[0][values.length % 3] > sum - dp[0][values.length % 3];
    }
    private boolean evenCoins(int[] values) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < values.length; i++) {
            if (i % 2 == 0) {
                even += values[i];
            } else {
                odd += values[i];
            }
        }
        return even != odd;
    }
}
