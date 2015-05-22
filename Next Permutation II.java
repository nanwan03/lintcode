public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public void nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    reverse(nums, i + 1, nums.length - 1);
                    return;
                }
            }
        }
        reverse(nums, 0, nums.length - 1);
    }
    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    private void reverse(int[] num, int left, int right) {
        while (left < right) {
            swap(num, left++, right--);
        }
    }
}
