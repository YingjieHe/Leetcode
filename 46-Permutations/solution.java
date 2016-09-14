public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        dfs(nums, res, new ArrayList<Integer>(), new HashSet<Integer>());
        return res;
    }
    
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, Set<Integer> set) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) continue;
            list.add(nums[i]);
            set.add(nums[i]);
            dfs(nums, res, list, set);
            int remove = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            set.remove(remove);
        }
    }
}