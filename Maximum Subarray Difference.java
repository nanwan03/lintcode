public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int tempMin = Integer.MAX_VALUE;
        int tempMax = Integer.MIN_VALUE;
        int[] leftMin = new int[nums.size()];
        int[] leftMax = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            tempMin = Math.min(tempMin, 0) + nums.get(i);
            tempMax = Math.max(tempMax, 0) + nums.get(i);
            min = Math.min(min, tempMin);
            max = Math.max(max, tempMax);
            leftMin[i] = min;
            leftMax[i] = max;
        }
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        tempMin = Integer.MAX_VALUE;
        tempMax = Integer.MIN_VALUE;
        int[] rightMin = new int[nums.size()];
        int[] rightMax = new int[nums.size()];
        for (int i = nums.size() - 1; i >= 0; i--) {
            rightMin[i] = min;
            rightMax[i] = max;
            tempMin = Math.min(tempMin, 0) + nums.get(i);
            tempMax = Math.max(tempMax, 0) + nums.get(i);
            min = Math.min(tempMin, min);
            max = Math.max(tempMax, max);
        }
        int rst = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size() - 1; i++) {
            rst = Math.max(rst, Math.max(Math.abs(leftMax[i] - rightMin[i]), Math.abs(rightMax[i] - leftMin[i])));
        }
        return rst;
    }
}


