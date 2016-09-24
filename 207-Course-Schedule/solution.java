public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(int[] prerequisite : prerequisites) {
            if(!map.containsKey(prerequisite[1])) {
                map.put(prerequisite[1], new ArrayList<Integer>());
            }
            map.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        int count = 0;
        while(!q.isEmpty()) {
            int course = q.poll();
            count++;
            if(map.containsKey(course)) {
                for(int i : map.get(course)) {
                    indegree[i]--;
                    if(indegree[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}