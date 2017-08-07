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
            int index = search(dp, 0, rst, i);
            dp[index] = i;
            if(index == rst) {
                rst++;
            }
        }

        return rst;
    }
    private int search(int[] A, int left, int right, int target) {
        if (right == 0) {
            return 0;
        }
        right = right - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A[right] < target) {
            return right + 1;
        } else if (A[right] == target || A[left] < target) {
            return right;
        } else {
            return left;
        }
    }
}

