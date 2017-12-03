public class Solution {
    /*
     * @param edges: a directed graph where each edge is represented by a tuple
     * @return: the number of edges
     */
    public int balanceGraph(int[][] edges) {
        // Write your code here
        if (edges == null || edges.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            map.put(u, map.getOrDefault(u, 0) - w);
            map.put(v, map.getOrDefault(v, 0) + w);
        }
        List<Integer> list = new ArrayList<Integer>();
        int posNum = 0;
        int negNum = 0;
        for (int i : map.values()) {
            if (i < 0) {
                negNum++;
            } else if (i > 0) {
                posNum++;
            }
            if (i != 0) {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            return 0;
        }
        int rst = 1;
        for (int k = Math.min(posNum, negNum); k >= 2; --k) {
            int[] subset = new int[k];
            Arrays.fill(subset, -1);
            if (partition(list, subset, new boolean[list.size()], k, 0, list.size() - 1)) {
                rst = k;
                break;
            }
        }
        return list.size() - rst;
    }
    private boolean partition(List<Integer> list, int[] subset, boolean[] used, int k, int curIndex, int limitIndex) {
    	if (curIndex == subset.length) {
    		for (int i = 0; i < subset.length; ++i) {
    			if (subset[i] != 0) {
    				return false;
    			}
    		}
    		return true;
    	}
        if (subset[curIndex] == 0) {
            return partition(list, subset, used, k, curIndex + 1, list.size() - 1);
        }
        for (int i = limitIndex; i >= 0; i--)
        {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            subset[curIndex] = (subset[curIndex] == -1 ? 0 : subset[curIndex]) + list.get(i);
            if(partition(list, subset, used, k, curIndex, i - 1)) {
            	return true;
            }
            used[i] = false;
            subset[curIndex] -= list.get(i);
            if (subset[curIndex] == 0) {
                subset[curIndex] = -1;
            }
        }
        return false;
    }
}