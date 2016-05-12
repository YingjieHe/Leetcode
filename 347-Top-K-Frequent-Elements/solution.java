public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0 || k <= 0) return res;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : nums){
            if(map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> p = new PriorityQueue<Map.Entry<Integer, Integer>>(new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2){
                return m2.getValue() - m1.getValue();
            }
        });
        p.addAll(map.entrySet());
        for(int i = 0; i < k; i++){
            res.add(p.poll().getKey());
        }
        return res;
    }
}