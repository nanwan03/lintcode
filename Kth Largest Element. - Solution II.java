class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        Random r = new Random();
        while (left < right) {
            int p = partition(nums, left, right, r.nextInt(right - left) + left);
            if (p == k - 1) {
                return nums[p];
            } else if (p < k - 1) {
                left = p + 1;
            } else {
                right = p - 1;
            }
        }
        return nums[k - 1];
    }
    private int partition(int[] nums, int left, int right, int pivot) {
        int pivotValue = nums[pivot];
        int cur = left;
        while (cur <= right) {
            if (nums[cur] > pivotValue) {
                swap(nums, cur++, left++);
            } else if (nums[cur] == pivotValue) {
                cur++;
            } else {
                swap(nums, cur, right--);
            }
        }
        return left;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
};