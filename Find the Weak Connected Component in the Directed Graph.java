/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        Map<Integer, Integer> root = new HashMap<Integer, Integer>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        if (nodes == null || nodes.size() == 0) {
            return rst;
        }
        for (DirectedGraphNode node : nodes) {
            root.put(node.label, node.label);
        }
        for (DirectedGraphNode node : nodes) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                union(root, node.label, neighbor.label);
            }
        }
        for (DirectedGraphNode node : nodes) {
            int parent = find(root, node.label);
            if (!map.containsKey(parent)) {
                map.put(parent, new ArrayList<Integer>());
            }
            map.get(parent).add(node.label);
        }
        Iterator<Map.Entry<Integer, List<Integer>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, List<Integer>> entry = it.next();
            Collections.sort(entry.getValue());
            rst.add(entry.getValue());
        }
        return rst;
    }
    private static void union(Map<Integer, Integer> root, int u, int v) {
        int uRoot = find(root, u);
        int vRoot = find(root, v);
        if (uRoot != vRoot) {
            root.put(Math.min(uRoot, vRoot), Math.max(uRoot, vRoot));
        }
    }
    private static int find(Map<Integer, Integer> root, int label) {
        if (root.get(label) != label) {
            root.put(label, find(root, root.get(label)));
        }
        return root.get(label);
    }
}
