class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int size = prices.length;
        int[] left = new int[size];
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < size; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        int[] right = new int[size];
        right[size - 1] = 0;
        int max = prices[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }
        int profit = 0;
        for (int i = 0; i < size; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        return profit;
    }
};
