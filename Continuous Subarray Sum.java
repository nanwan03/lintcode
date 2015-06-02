public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return rst;
        }
        int sumSoFar = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;
        int first = 0;
        int tempFirst = 0;
        int last = 0;
        for (int i = 0; i < A.length; i++) {
            if(sumSoFar <= 0) {
                sumSoFar = 0;
                tempFirst = i;
            }
            sumSoFar += A[i];
            if (sumSoFar > sum) {
                sum = sumSoFar;
                first = tempFirst;
                last = i;
            }
        }
        rst.add(first);
        rst.add(last);
        return rst;
    }
}
