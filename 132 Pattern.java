public class Solution {
    /**
     * @param nums a list of n integers
     * @return true if there is a 132 pattern or false
     */
    public boolean find132pattern(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return false;
        }
        int s3 = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] < s3) {
                return true;
            } else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    s3 = stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}