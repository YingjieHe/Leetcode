public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = Integer.MIN_VALUE;
        for(int i : nums) {
            if(map.containsKey(i)) continue;
            int left = map.containsKey(i - 1)? map.get(i - 1): 0;
            int right = map.containsKey(i + 1)? map.get(i + 1): 0;
            int sum = left + right + 1;
            map.put(i, sum);
            res = Math.max(res, sum);
            map.put(i - left, sum);
            map.put(i + right, sum);
        }
        return res;
    }
}