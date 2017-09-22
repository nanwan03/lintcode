public class Solution {
    /*
     * @param : an array of integer
     * @return: the first missing prime number
     */
    public int firstMissingPrime(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0 || nums[0] != 2) {
            return 2;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }
        for (int i : nums) {
            int next = nextPrime(i);
            if (!set.contains(next)) {
                return next;
            }
            set.add(next);
        }
        return nextPrime(nums[nums.length - 1]);
    }
    private int nextPrime(int num) {
        num++;
        for (int i = 2; i < num; ++i) {
            if(num % i == 0) {
                num++;
                i = 2;
            }
        }
        return num;
    }
};