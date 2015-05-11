public class Solution {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int numTrees(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if(n==0 || n==1)
        {
            map.put(0, 1);
            map.put(1, 1);
            return 1;
        }
        int rst = 0;
        for(int i=1;i<=n;i++)
        {
            rst += numTrees(i-1)*numTrees(n-i);
        }
        map.put(n, rst);
        return rst;
    }
}