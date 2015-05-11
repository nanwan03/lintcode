import java.util.*;

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return rst;
        }
        Arrays.sort(candidates);
        List<Integer> items = new ArrayList<Integer>();
        helper(rst, items, candidates, target, 0);
        return rst;
    }
    private void helper(List<List<Integer>> rst, List<Integer> items, int[] a, int target, int pos) {
        if (target == 0) {
            rst.add(new ArrayList<Integer>(items));
            return;
        }
        for (int i = pos; i < a.length; i++) {
            if (a[i] <= target) {
                items.add(a[i]);
                helper(rst, items, a, target - a[i], i);
                items.remove(items.size() - 1);
            }
        }
    }
}
