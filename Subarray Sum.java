public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        for (int i = 0; i< nums.length; i++) {
            sum += nums[i];
            if (nums[i] == 0) {
                rst.add(i);
                rst.add(i);
                break;
            } else if (sum == 0) {
                rst.add(0);
                rst.add(i);
                break;
            } else {
                if (!map.containsKey(sum)) {
                    map.put(sum, i + 1);
                } else {
                    rst.add(map.get(sum));
                    rst.add(i);
                    break;
                }
            }
        }
        return rst;
    }
}
