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
            return false;
        }
        Set<Integer> isvisited = new HashSet<Integer>();
        isvisited.add(s.label);
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            if (node.label == t.label) {
                return true;
            }
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (isvisited.add(neighbor.label)) {
                    queue.offer(neighbor);
                }
            }
        }
        return false;
    }
}