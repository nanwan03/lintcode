import java.util.ArrayList;


public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        int flag = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i)  > nums.get(i + 1)) {
                flag = i;
            }
        }
        if (flag == 0) {
            return;
        }
        reverseList(nums, 0, flag);
        reverseList(nums, flag + 1, nums.size() - 1);
        reverseList(nums, 0, nums.size() - 1);
    }
    private void reverseList(ArrayList<Integer> nums, int start, int end) {
        int length = end +  1 - start;
        for (int i = 0; i < length / 2; i ++) {
            int temp = nums.get(start + i);
            nums.set(start + i, nums.get(start + length - 1 - i));
            nums.set(start + length - 1 - i, temp);
        }
    }
}
