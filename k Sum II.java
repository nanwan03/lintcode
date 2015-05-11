public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (A == null || A.length == 0 || k == 0) {
            return rst;
        }
        Arrays.sort(A);
        ArrayList<Integer> items = new ArrayList<Integer>();
        helper(A, k, target, rst, items, 0);
        return rst;
    }
    private void helper(int[] A, int k, int target, List<ArrayList<Integer>> rst, List<Integer> items, int pos) {
        if (k == 0 && target == 0) {
            rst.add(new ArrayList<Integer>(items));
            return;
        }
        if (k > 0 && target > 0) {
            for (int i = pos; i < A.length; i++) {
                if (A[i] <= target) {
                    items.add(A[i]);
                    helper(A, k - 1, target - A[i], rst, items, i + 1);
                    items.remove(items.size() - 1);
                }
            }
        }
    }
}

