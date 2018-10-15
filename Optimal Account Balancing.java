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
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            map.put(u, map.getOrDefault(u, 0) + weight);
            map.put(v, map.getOrDefault(v, 0) - weight);
        }
        List<Integer> list = new ArrayList<Integer>();
        int posNum = 0;
        int negNum = 0;
        for (int v : map.values()) {
            if (v != 0) {
                list.add(v);
                if (v > 0) {
                    posNum++;
                } else {
                    negNum++;
                }
            }
        }
        if (list.size() == 0) {
            return 0;
        }
        int size = list.size();
        int left = 0;
        int right = Math.min(posNum, negNum);
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (isValid(list, new boolean[size], 0, mid, 0, 0, 0)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (isValid(list, new boolean[size], 0, right, 0, 0, 0)) {
            return list.size() - right;
        }
        if (isValid(list, new boolean[size], 0, left, 0, 0, 0)) {
            return list.size() - left;
        }
        return list.size() - 1;
    }
    private boolean isValid(List<Integer> list, boolean[] isused, int start, int k, int curSum, int curNum, int usedNum) {
        if (k == 1) {
            return usedNum != isused.length;
        }
        if (curSum == 0 && curNum > 0) {
            return isValid(list, isused, 0, k - 1, 0, 0, usedNum);
        }
        for (int i = start; i < list.size(); ++i) {
            if (!isused[i]) {
                isused[i] = true;
                //System.out.println(curNum);
                if (isValid(list, isused, i + 1, k, curSum + list.get(i), curNum + 1, usedNum + 1)) {
                    return true;
                }
                //System.out.println(curNum);
                isused[i] = false;
            }
        }
        return false;
    }
}