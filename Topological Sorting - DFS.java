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
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */   
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> rst = new ArrayList<DirectedGraphNode>();
        if (graph == null || graph.size() == 0) {
            return rst;
        }
        Map<DirectedGraphNode, Integer> visited = new HashMap<DirectedGraphNode, Integer>();
        for (DirectedGraphNode node : graph) {
            visited.put(node, 0);
        }
        Stack<DirectedGraphNode> stack = new Stack<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            DFS(node, visited, graph, stack);
        }
        while (!stack.isEmpty()) {
            rst.add(stack.pop());
        }
        return rst;
    }
    private void DFS(DirectedGraphNode node, Map<DirectedGraphNode, Integer> map, List<DirectedGraphNode> graph, Stack<DirectedGraphNode> stack) {
        if (map.get(node) != 0) {
            return;
        }
        map.put(node, 1);
        for (DirectedGraphNode neighbor : node.neighbors) {
            if (map.get(neighbor) == 0) {
                DFS(neighbor, map, graph, stack);
            }
        }
        map.put(node, 2);
        stack.push(node);
    }
}