public class Solution {
    /**
     * @param nums an array containing n + 1 integers which is between 1 and n
     * @return the duplicate one
     */
    public int findDuplicate(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        int head = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        while (head !=  slow) {
            head = nums[head];
            slow = nums[slow];
        }
        return head;
    }
}