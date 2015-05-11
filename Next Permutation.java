public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's next permuation
     */
    public ArrayList<Integer> nextPermuation(ArrayList<Integer> nums) {
		// write your code
		if (nums == null || nums.size() == 0) {
		    return nums;
		}
		for (int i = nums.size() - 2; i >= 0; i--) {
		    for (int j = nums.size() - 1; j >= i; j--) {
		        if (nums.get(j) > nums.get(i)) {
		            swap(nums, i, j);
		            reverse(nums, i + 1, nums.size() - 1);
		            return nums;
		        }
		    }
		}
		reverse(nums, 0, nums.size() - 1);
		return nums;
    }
    private void swap(ArrayList<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
    private void reverse(ArrayList<Integer> nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
}

