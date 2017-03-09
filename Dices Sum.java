public class Solution {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        //dp[i][j]表示i个骰子一共得到j点的概率。要得到dp[i][j]可以考虑若最后一个筛子的点数为k（1~6），则前i－1个筛子一共得到的点数为j-k（因为i-1个筛子至少得到i-1点，所以j-k >= i - 1 => k <= j - i + 1）。所以只要把最后一个筛子为k的各种情况加起来最后再除以6即可（每多一个筛子概率要多除以一个6）。
        List<Map.Entry<Integer, Double>> results = new ArrayList<Map.Entry<Integer, Double>>();
        
        double[][] dp = new double[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; ++i)
            dp[1][i] = 1.0 / 6;

        for (int i = 2; i <= n; ++i) {
            for (int j = i; j <= 6 * n; ++j) {
                for (int k = 1; k <= 6; ++k) {
                    if (j > k) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
                dp[i][j] /= 6.0;
            }
        }
        for (int i = n; i <= 6 * n; ++i) {
            results.add(new AbstractMap.SimpleEntry<Integer, Double>(i, dp[n][i]));
        }
        return results;
    }
}