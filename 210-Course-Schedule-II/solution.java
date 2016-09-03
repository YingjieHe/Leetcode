public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : prerequisites) {

            if(!map.containsKey(edge[1])) map.put(edge[1], new ArrayList<Integer>());
            map.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        int[] res = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        int order = 0;
        while(!q.isEmpty()) {
            int pre = q.poll();
            res[order++] = pre;
            if(map.containsKey(pre)) {
                for(int next : map.get(pre)) {
                    if(--indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
        }
        return order == numCourses? res: new int[0];
    }
}