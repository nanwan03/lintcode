public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(ArrayList<Integer> nums, int k) {
	    //write your code here
	    if (nums == null || nums.size() == 0) {
	        return 0;
	    }
	    int left = 0;
	    int right = nums.size() - 1;
	    int cur = left;
	    while (cur <= right) {
	        if (nums.get(cur) < k) {
	            Collections.swap(nums, left++, cur++);
	        } else if (nums.get(cur) == k) {
	            cur++;
	        } else {
	            Collections.swap(nums, cur, right--);
	        }
	    }
	    return left;
    }
}
