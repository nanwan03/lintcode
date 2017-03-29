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
            int pieces = getPiece(L, mid);
            if (pieces < k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        int leftNum = getPiece(L, left);
        int rightNum = getPiece(L, right);
        if (rightNum >= k) {
            return right;
        }
        if (leftNum >= k) {
            return left;
        }
        return 0;
    }
    private int getPiece(int[] L, int length) {
        int rst = 0;
        for (int i : L) {
            rst += i / length;
        }
        return rst;
    }
}