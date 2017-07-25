public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int length = -1;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            while (sum - nums[left] >= s) {
                sum -= nums[left++];
            }
            if (sum >= s) {
                length = length == -1 ? i - left + 1 : Math.min(length, i - left + 1);
            }
        }
        return length;
    }
}