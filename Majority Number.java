public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int candidate = 0;
        int count = 0;
        for (int i : nums) {
            if (count == 0) {
                candidate = i;
                count++;
            } else if (candidate == i) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}

