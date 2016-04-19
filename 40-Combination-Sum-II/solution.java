public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(res, list, 0, target, candidates);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> list, int start, int sum, int[] candidates){
        if(sum == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = start; i < candidates.length && sum >= candidates[i]; i++){
            if (i > start && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            dfs(res, list, i + 1, sum - candidates[i], candidates);
            list.remove(list.size() - 1);
        }
    }
}