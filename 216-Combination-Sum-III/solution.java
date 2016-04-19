public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(res, list, 1, n, k);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> list, int start, int sum, int k){
        if(list.size() == k && sum == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if(list.size() >= k) return;
        for(int i = start; i <= 9; i++){
            list.add(i);
            dfs(res, list, i + 1, sum - i, k);
            list.remove(list.size() - 1);
        }
    }
}