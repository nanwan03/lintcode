class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
       int right_part = n & ((1 << i) - 1);
        // The behavior of right shift >= 32 is undefined in C++.
        int left_part = j >= 31 ? 0 : (n >> (j + 1)) << (j + 1);
        return left_part | (m << i) | right_part;
    }
}