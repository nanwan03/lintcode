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
	private int timeF = 1;
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
    	ArrayList<DirectedGraphNode> rst = new ArrayList<DirectedGraphNode>();
    	if (graph == null || graph.size() == 0) {
    		return rst;
    	}
    	Map<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
    	for (DirectedGraphNode node : graph) {
    		map.put(node, 0);
    		rst.add(node);
    	}
    	int[] time = new int[graph.size()];
    	DFS(map, graph, time);
    	for (DirectedGraphNode node : graph) {
    		rst.set(graph.size() - time[node.label], node);
    	}
    	return rst;
    }
    private void DFS(Map<DirectedGraphNode, Integer> map, ArrayList<DirectedGraphNode> graph, int[] time) {
    	for (DirectedGraphNode node : graph) {
    		if (map.get(node) == 0) {
    			DFS(node, map, graph, time);
    		}
    	}
    }
    private void DFS(DirectedGraphNode node, Map<DirectedGraphNode, Integer> map, ArrayList<DirectedGraphNode> graph, int[] time) {
    	map.put(node, 1);
    	for (DirectedGraphNode neighbor : node.neighbors) {
    		if (map.get(neighbor) == 0) {
    			DFS(neighbor, map, graph, time);
    		}
    	}
    	map.put(node, 2);
    	time[node.label] = timeF++;
    }
}
