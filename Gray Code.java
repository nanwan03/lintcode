public class Solution {
    /**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
        // Write your code here
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (n < 2) {
            for (int i = 0; i <=n; i++) {
                rst.add(i);
            }
            return rst;
        }
        rst = grayCode(n - 1);
        List<Integer> items = new ArrayList<Integer>(rst);
        Collections.reverse(items);
        int x = 1 << (n - 1);
        for (int i = 0; i < items.size(); i++) {
            items.set(i, items.get(i) + x);
        }
        rst.addAll(items);
        return rst;
    }
}
