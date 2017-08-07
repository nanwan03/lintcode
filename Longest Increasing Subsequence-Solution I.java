public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        int[] dp = new int[nums.length];
        int rst = 0;
        for(int i : nums) {
            int index = Arrays.binarySearch(dp, 0, rst, i);
            if(index < 0) {
                index = -(index + 1);
            }
            dp[index] = i;
            if(index == rst) {
                rst++;
            }
        }

        return rst;
    }
}

