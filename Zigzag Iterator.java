public class ZigzagIterator {
    /*
    * @param v1: A 1d vector
    * @param v2: A 1d vector
    */
    private int[] cur = new int[2];
    private List<List<Integer>> list = new ArrayList<List<Integer>>();
    private int index = 0;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // do intialization if necessary
        list.add(v1);
        list.add(v2);
        index = v1.size() == 0 ? 1 : 0;
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        if (hasNext()) {
            int rst = list.get(index).get(cur[index]);
            cur[index]++;
            index =  (index + 1) % 2;
            if (cur[index] >= list.get(index).size()) {
                index = (index + 1) % 2;
            }
            return rst;
        } else {
            return -1;
        }
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        return cur[0] < list.get(0).size() || cur[1] < list.get(1).size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */