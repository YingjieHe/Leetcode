/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        map.put(node.label, new UndirectedGraphNode(node.label));
        while(!q.isEmpty()) {
            UndirectedGraphNode temp = q.poll();
            for(UndirectedGraphNode neighbor : temp.neighbors) {
                if(!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    q.offer(neighbor);
                }
                map.get(temp.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return map.get(node.label);
    }
}