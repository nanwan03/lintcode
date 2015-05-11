/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        if (graph == null || graph.size() == 0) {
            return true;
        }
        Set<Integer> visited = new HashSet<Integer>();
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        queue.offer(s);
        visited.add(s.label);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                DirectedGraphNode node = queue.poll();
                if (node.label == t.label) {
                    return true;
                }
                for (DirectedGraphNode neighbor : node.neighbors) {
                    if(visited.add(neighbor.label)) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return false;
    }
}
