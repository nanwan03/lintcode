public class Solution {
    /**
     * @param nums: the array
     * @param target: the target
     * @return: the number of subsets which meet the following conditions
     */
    public long subsetWithTarget(int[] nums, int target) {
        // Write you code here
        Arrays.sort(nums);
        long rst = 0;
        for(int i = 0; i < nums.length; i++) {
            int j = i;
            while(j + 1 < nums.length && nums[i] + nums[j + 1] < target) {
                j++;
            }
            if(nums[i] + nums[j] < target) {
                rst += ((long)1<<(j - i)) ;
            }
            
        }
        return rst;
    }
}