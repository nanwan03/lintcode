public class Solution {
    /*
     * @param n: a positive integer
     * @return: n x 3 matrix
     */
    public List<List<Integer>> consistentHashing(int n) {
        // write your code here
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (n == 0) {
            return rst;
        }
        rst.add(Arrays.asList(new Integer[]{0, 359, 1}));
        for (int i = 1; i < n; ++i) {
            int index = 0;
            for (int j = 0; j < i; ++j) {
                if (rst.get(j).get(1) - rst.get(j).get(0) > rst.get(index).get(1) - rst.get(index).get(0)) {
                    index = j;
                }
            }
            int x = rst.get(index).get(0);
            int y = rst.get(index).get(1);
            rst.get(index).set(1, (x + y) / 2);
            rst.add(Arrays.asList(new Integer[]{(x + y) / 2 + 1, y, i + 1}));
        }
        return rst;
    }
}