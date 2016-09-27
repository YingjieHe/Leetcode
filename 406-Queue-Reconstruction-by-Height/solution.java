public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0 || people[0].length == 0) return people;
        Arrays.sort(people, new Comparator<int[]>(){
           public int compare(int[] a, int[] b) {
               if(a[0] != b[0]) return b[0] - a[0];
               else return a[1] - b[1];
           } 
        });
        
        List<int[]> list = new LinkedList<>();
        for(int[] cur : people) {
            if(cur[1] >= list.size()) {
                list.add(cur);
            }
            else {
                list.add(cur[1], cur);
            }
        }
        return list.toArray(new int[people.length][]);
    }
}