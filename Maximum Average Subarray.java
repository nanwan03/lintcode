public class Solution {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int size = nums.length;
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return helper(nums, k, (double)min, (double)max);
    }
    private double helper(int[] nums, int k, double left, double right) {
        int size = nums.length;
        double[] sum = new double[size + 1];
        sum[0] = 0;
        while (right - left >= 1e-6) {
            double mid = (left + right) / 2.0;
            double prevMin = 0;
            boolean check = false;
            for (int i = 1; i <= size; ++i) {
                sum[i] = sum[i - 1] + nums[i - 1] - mid;
                if (i >= k) {
                    prevMin = Math.min(prevMin, sum[i - k]);
                    if (sum[i] - prevMin >= 0) {
                        check = true;
                        break;
                    }
                }
            }
            if (check) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}