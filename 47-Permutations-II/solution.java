public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(res, nums, new ArrayList<Integer>(), visited);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> list, boolean[] visited) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] || (i != 0 && nums[i] == nums[i - 1] && visited[i - 1])) continue;
            visited[i] = true;
            list.add(nums[i]);
            dfs(res, nums, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}