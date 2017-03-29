public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }
        int max = L[0];
        for (int i : L) {
            max = Math.max(i, max);
        }
        return helper(L, k, max);
    }
    private int helper(int[] L, int k, int max) {
        int left = 1;
        int right = max;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isValid(L, mid, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (isValid(L, right, k)) {
            return right;
        }
        if (isValid(L, left, k)) {
            return left;
        }
        return 0;
    }
    private boolean isValid(int[] L, int length, int k) {
        int rst = 0;
        for (int i : L) {
            rst += i / length;
        }
        return rst >= k;
    }
}