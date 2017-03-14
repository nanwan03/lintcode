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
        Map<DirectedGraphNode, Boolean> visited = new HashMap<DirectedGraphNode, Boolean>();
        for (DirectedGraphNode node : graph) {
            visited.put(node, false);
        }
        for (DirectedGraphNode node : graph) {
            if (!visited.get(node)) {
                DFS(graph, rst, visited, node);
            }
        }
        Collections.reverse(rst);
        return rst;
    }
    private void DFS(ArrayList<DirectedGraphNode> graph, ArrayList<DirectedGraphNode> rst, Map<DirectedGraphNode, Boolean> visited, DirectedGraphNode node) {
        visited.put(node, true);
        for (DirectedGraphNode neighbor : node.neighbors) {
            if (!visited.get(neighbor)) {
                DFS(graph, rst, visited, neighbor);
            }
        }
        rst.add(node);
    }
}