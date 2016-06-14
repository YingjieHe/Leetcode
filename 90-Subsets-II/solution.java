public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        dfs(res, nums, list, 0);
        return res;
    }
    public void dfs(List<List<Integer>> res, int[] nums, List<Integer> list, int start){
        if(start <= nums.length){
            res.add(new ArrayList<Integer>(list));
        }
        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            dfs(res, nums, list, i + 1);
            list.remove(list.size() - 1);
            while(i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
        }
    }
}