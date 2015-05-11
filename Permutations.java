import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> items = new ArrayList<Integer>();
        if (nums == null) {
            return rst;
        }
        permuteHelper(rst, items, nums);
        return rst;
    }
    public void permuteHelper(ArrayList<ArrayList<Integer>> rst,
                                ArrayList<Integer> items,
                                ArrayList<Integer> nums) {
        if (nums.size() == 1) {
            items.add(nums.get(0));
            rst.add((ArrayList<Integer>) items.clone());
            items.remove(items.size() - 1);
        } else {
            for (int i = 0; i < nums.size(); i++) {
                items.add(nums.get(i));
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.addAll(nums.subList(0, i));
                temp.addAll(nums.subList(i + 1, nums.size()));
                permuteHelper(rst, items, temp);
                items.remove(items.size() - 1);
            }
        }
    }
}

