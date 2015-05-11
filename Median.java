public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        return findK(nums, 0, size - 1, (size - 1) / 2);
    }
    private int findK(int[] nums, int left, int right, int k) {
        Random r = new Random();
        while (left < right) {
            int pivot = partition(nums, left, right, r.nextInt(right - left + 1) + left);
            if (pivot == k) {
                return nums[pivot];
            } else if (pivot < k) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return left == k ? nums[left] : nums[right];
    }
    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        int cur = left;
        while (cur <= right) {
            if (nums[cur] < pivotValue) {
                swap(nums, left++, cur++);
            } else if (nums[cur] == pivotValue) {
                cur++;
            } else {
                swap(nums, cur, right--);
            }
        }
        return left;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

