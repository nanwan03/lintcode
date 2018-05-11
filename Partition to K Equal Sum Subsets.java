public class Solution {
    /**
     * @param nums: a list of integer
     * @param k: an integer
     * @return: return a boolean, denote whether the array can be divided into k non-empty subsets whose sums are all equal
     */
    public boolean partitiontoEqualSumSubsets(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        return helper(nums, new boolean[nums.length], 0, k, 0, 0, sum / k);
    }
    private boolean helper(int[] nums, boolean[] isused, int startIndex, int k, int curSum, int curNum, int target) {
        if (k == 1) {
            return true;
        }
        if (curSum == target && curNum > 0) {
            return helper(nums, isused, 0, k-1, 0, 0, target);
        }
        for (int i = startIndex; i < nums.length; ++i){
            if (!isused[i]) {
                isused[i] = true;
                if (helper(nums, isused, i + 1, k, curSum + nums[i], curNum++, target)) {
                    return true;
                }
                isused[i] = false;
            }
        }
        return false;
    }
}