import java.util.*;
import java.util.Map.*;
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
    	Map<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
    	for (DirectedGraphNode node : graph) {
    		if (!map.containsKey(node)) {
    			map.put(node, 0);
    		}
    		for (DirectedGraphNode neighbor : node.neighbors) {
    			if (!map.containsKey(neighbor)) {
    				map.put(neighbor, 1);
    			} else {
    				map.put(neighbor, map.get(neighbor) + 1);
    			}
    		}
    	}
    	while (map.size() != 0) {
    		Iterator<Entry<DirectedGraphNode, Integer>> it = map.entrySet().iterator();
    		while (it.hasNext()) {
    			Entry<DirectedGraphNode, Integer> entry = it.next();
    			if (entry.getValue() == 0) {
    				DirectedGraphNode node = entry.getKey();
    				rst.add(node);
    				it.remove();
    				for (DirectedGraphNode neighbor : node.neighbors) {
    					map.put(neighbor, map.get(neighbor) - 1);
    				}
    			}
    		}
    	}
    	return rst;
    }
}
