import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int sum = nums.get(0) < 0 ? 0 : nums.get(0);
        int max = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            sum += nums.get(i);
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
