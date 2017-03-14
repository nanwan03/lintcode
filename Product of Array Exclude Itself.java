public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> rst = new ArrayList<Long>();
        if (A == null || A.size() < 2) {
            rst.add(1L);
            return rst;
        }
        long product = 1;
        for (int i : A) {
            rst.add(product);
            product *= i;
        }
        product = 1;
        for (int i = A.size() - 1; i >= 0; i--) {
            rst.set(i, product * rst.get(i));
            product *= A.get(i);
        }
        return rst;
    }
}

