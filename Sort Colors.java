class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int cur = 0;
        int right = nums.length - 1;
        while (cur <= right) {
            if (nums[cur] == 0) {
                swap(nums, left++, cur++);
            } else if (nums[cur] == 1) {
                cur++;
            } else {
                swap(nums, cur, right--);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
