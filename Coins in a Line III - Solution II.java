public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     * Reference: EPI 17.15 Pick up Coins for maximum gain
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            return false;
        }
        int sum = 0;
        for (int i : values) {
            sum += i;
        }
        int[][] dp = new int[values.length][values.length];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        int maxGain = pickUpCoinsHelper(values, 0, values.length - 1, dp);
        return maxGain > sum - maxGain;
    }
    private int pickUpCoinsHelper(int[] values, int a, int b, int[][] dp) {
        if (a > b) {
          return 0; // Base condition.
        }

        if (dp[a][b] == -1) {
          dp[a][b] = Math.max(
              values[a]
                  + Math.min(pickUpCoinsHelper(values, a + 2, b, dp), pickUpCoinsHelper(values, a + 1, b - 1, dp)),
              values[b]
                  + Math.min(pickUpCoinsHelper(values, a + 1, b - 1, dp), pickUpCoinsHelper(values, a, b - 2, dp))
          );
        }
        return dp[a][b];
  }
}
