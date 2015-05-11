class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<Integer>();
        int sizeA = A.size();
        int sizeB = B.size();
        int indexA = 0;
        int indexB = 0;
        while (indexA < sizeA && indexB < sizeB) {
            rst.add(A.get(indexA) < B.get(indexB) ? A.get(indexA++) : B.get(indexB++));
        }
        while (indexA < sizeA) {
            rst.add(A.get(indexA++));
        }
        while (indexB < sizeB) {
            rst.add(B.get(indexB++));
        }
        return rst;
    }
}
