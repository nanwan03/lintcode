public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dup = 1;
        int tail = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[++tail] = nums[i];
                dup = 1;
            } else if (dup == 1) {
                nums[++tail] = nums[i];
                dup = 0;
            }
        }
        return ++tail;
    }
}
