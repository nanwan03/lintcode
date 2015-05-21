public class Solution {
	/**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
	  public int maxProfit(int[] array, int k) {
	    // write your solution here
	    if (array == null || array.length == 0) {
	      return 0;
	    }
	    int[] kSum = new int[k * 2];
	    int profit = 0;
	    Arrays.fill(kSum, Integer.MIN_VALUE);
	    for (int i = 0; i < array.length; i++) {
	      int[] prevKSum = Arrays.copyOf(kSum, kSum.length);
	      for (int j = 0, sign = -1; j < Math.min(kSum.length, i + 1); j++, sign *= -1) {
	          int diff = sign * array[i] + (j == 0 ? 0 : prevKSum[j - 1]);
	          kSum[j] = Math.max(diff, prevKSum[j]);
	          profit = Math.max(profit, kSum[j]);
	      }
	    }
	    return profit;
	  }
}