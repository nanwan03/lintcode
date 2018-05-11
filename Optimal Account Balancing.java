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
        int left = 1;
        int right = Math.min(posNum, negNum);
        while(left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (isValid(list, new boolean[list.size()], 0, mid, 0, 0, 0)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (isValid(list, new boolean[list.size()], 0, right, 0, 0, 0)) {
            return list.size() - right;
        }
        if (isValid(list, new boolean[list.size()], 0, left, 0, 0, 0)) {
            return list.size() - left;
        }
        return list.size() - 1;
    }
    private boolean isValid(List<Integer> nums, boolean[] isused, int startIndex, int k, int curSum, int curNum, int target) {
        if (k == 1) {
            return true;
        }
        if (curSum == target && curNum > 0) {
            return isValid(nums, isused, 0, k-1, 0, 0, target);
        }
        for (int i = startIndex; i < nums.size(); ++i){
            if (!isused[i]) {
                isused[i] = true;
                if (isValid(nums, isused, i + 1, k, curSum + nums.get(i), curNum++, target)) {
                    return true;
                }
                isused[i] = false;
            }
        }
        return false;
    }
}