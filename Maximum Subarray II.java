public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int size = nums.size();
        int maxSoFar = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int[] left = new int[size];
        for (int i = 0; i < size; i++) {
            maxSoFar = Math.max(maxSoFar, 0) + nums.get(i);
            max = Math.max(max, maxSoFar);
            left[i] = max;
        }
        maxSoFar = Integer.MIN_VALUE;
        max = Integer.MIN_VALUE;
        int[] right = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            right[i] = max;
            maxSoFar = Math.max(maxSoFar, 0) + nums.get(i);
            max = Math.max(max, maxSoFar);
        }
        int rst = Integer.MIN_VALUE;
        for (int i = 0; i < size - 1; i++) {
            rst = Math.max(rst, left[i] + right[i]);
        }
        return rst;
    }
}


