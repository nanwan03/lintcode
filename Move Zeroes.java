public class Solution {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int cur = 0;
        while (cur < nums.length) {
            if (nums[cur] != 0) {
                swap(nums, left++, cur++);
            } else {
                cur++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}