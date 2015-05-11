public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return rst;
        }
        Arrays.sort(num);
        List<Integer> items = new ArrayList<Integer>();
        helper(rst, items, num, target, 0);
        return rst;
    }
    public void helper(List<List<Integer>> rst, List<Integer> items,
                        int[] num, int target, int start) {
        if (target == 0) {
            rst.add(new ArrayList<Integer>(items));
        } else {
            for (int i = start; i < num.length; i++) {
                if (i > start && num[i] == num[i - 1]) {
                    continue;
                }
                if (num[i] > target) {
                    break;
                }
                items.add(num[i]);
                helper(rst, items, num, target - num[i], i + 1);
                items.remove(items.size() - 1);
            }
        }
    }
}
