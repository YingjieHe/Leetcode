public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(res, list, 1, n, k);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> list, int start, int n, int k){
        if(list.size() == k){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = start; i <= n; i++){
            list.add(i);
            dfs(res, list, i + 1, n, k);
            list.remove(list.size() - 1);
        }
    }
}