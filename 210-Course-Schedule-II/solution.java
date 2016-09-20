public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            if(!map.containsKey(prerequisite[1])) {
                map.put(prerequisite[1], new ArrayList<Integer>());
            }
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int[] res = new int[numCourses];
        int order = 0;
        while(!q.isEmpty()) {
            int course = q.poll();
            res[order++] = course;
            if(map.containsKey(course)) {
                for(int i : map.get(course)) {
                    indegree[i]--;
                    if(indegree[i] == 0) q.offer(i);
                }
            }
        }
        return order == numCourses? res: new int[0];
    }
}