public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] arr : prerequisites) {
            if(!map.containsKey(arr[1])) map.put(arr[1], new ArrayList<Integer>());
            map.get(arr[1]).add(arr[0]);
            indegree[arr[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        int[] res = new int[numCourses];
        int order = 0;
        while(!q.isEmpty()) {
            int course = q.poll();
            res[order++] = course;
            if(map.containsKey(course)) {
                for(int i : map.get(course)) {
                    if(--indegree[i] == 0) q.offer(i);
                }
            }
        }
        return order == numCourses? res: new int[0];
    }
}