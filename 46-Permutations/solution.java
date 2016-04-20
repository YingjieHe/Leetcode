public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> list = new ArrayList<Integer>();
        dfs(res, list, nums);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfs(res, list, nums);
            list.remove(list.size() - 1);
        }
    }
}