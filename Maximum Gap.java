class Solution {
    /**
     * @param nums: an array of integers
     * @return: the maximum difference
     */
    public int maximumGap(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        if (max == min) {
            return 0;
        }
        int n = nums.length;
        double dist = (double)(max - min) / (double)(n - 1);
        int[] minL = new int[n - 1];
        int[] maxL = new int[n - 1];
        Arrays.fill(minL, -1);
        Arrays.fill(maxL, -1);
        for (int i : nums) {
            int idx = (i == max) ? (n - 2) : (int)((i - min) / dist);
            if (minL[idx] == -1 || i < minL[idx]) {
                minL[idx] = i;
            }
            if (maxL[idx] == -1 || i > maxL[idx]) {
                maxL[idx] = i;
            }
        }
        int maxGap = maxL[0] - minL[0];
        int prevMax = maxL[0];
        for (int i = 0; i < n - 1; i++) {
            if (minL[i] == -1) {
                continue;
            }
            maxGap = Math.max(maxGap, minL[i] - prevMax);
            prevMax = maxL[i];
        }
        return maxGap;
    }
}
