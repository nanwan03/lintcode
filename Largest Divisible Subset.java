public class Solution {
    /**
     * @param nums a set of distinct positive integers
     * @return the largest subset 
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Write your code here
        List<Integer> rst = new ArrayList<Integer>();
        if(nums == null || nums.length==0) {
            return rst;
        }
        Arrays.sort(nums);
        int size = nums.length;
        int[] dp = new int[size];
        int[] parent = new int[size];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        int max=0;
        int maxIndex=-1;
        for(int i = 0; i < size; i++){
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if(max < dp[i]){
                max = dp[i];
                maxIndex = i;
            }
        }
     
        int i = maxIndex;
        while(i >= 0){
            rst.add(nums[i]);
            i = parent[i];
        }
        return rst;
    }
}