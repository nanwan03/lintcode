public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
    	if(nums==null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for(int i=0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        int sumShouldBe = ((nums.length)*(nums.length+1))/2;
        return (sumShouldBe - sum);
    }
}
