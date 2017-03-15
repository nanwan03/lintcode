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
        Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (visited.add(node)) {
                DFS(graph, visited, rst, node);
            }
        }
        Collections.reverse(rst);
        return rst;
    }
    private void DFS(ArrayList<DirectedGraphNode> graph, Set<DirectedGraphNode> visited, ArrayList<DirectedGraphNode> rst, DirectedGraphNode node) {
        visited.add(node);
        for (DirectedGraphNode neighbor : node.neighbors) {
            if (visited.add(neighbor)) {
                DFS(graph, visited, rst, neighbor);
            }
        }
        rst.add(node);
    }
}