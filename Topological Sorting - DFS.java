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
        Set<DirectedGraphNode> isvisited = new HashSet<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (isvisited.add(node)) {
                DFS(rst, isvisited, node);
            }
        }
        Collections.reverse(rst);
        return rst;
    }
    private void DFS(ArrayList<DirectedGraphNode> rst, Set<DirectedGraphNode> isvisited, DirectedGraphNode node) {
        for(DirectedGraphNode neighbor : node.neighbors) {
            if (isvisited.add(neighbor)) {
                DFS(rst, isvisited, neighbor);
            }
        }
        rst.add(node);
    }
}