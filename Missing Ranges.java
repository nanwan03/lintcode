public class Solution {
    /*
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
        List<String> rst = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            if (lower == upper) {
                rst.add(String.valueOf(lower));
            } else {
                rst.add(lower + "->" + upper);
            }
            return rst;
        }
        int prev = lower - 1;
        for (int i = 0; i <= nums.length; ++i) {
            int cur = i < nums.length ? nums[i] : upper + 1;
            if (prev == cur || prev + 1 == cur) {
                prev = cur;
            } else {
                int missingStart = prev + 1;
                int missingEnd = cur - 1;
                if (missingStart == missingEnd) {
                    rst.add(String.valueOf(missingStart));
                } else {
                    rst.add(missingStart + "->" + missingEnd);
                }
                prev = cur;
            }
        }
        return rst;
    }
}