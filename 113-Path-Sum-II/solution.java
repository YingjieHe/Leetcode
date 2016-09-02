/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res, list, root, sum);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
        if(root == null) return;
        list.add(root.val);
        if(root.left == null && root.right == null && sum - root.val == 0) {
            res.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
            return;
        }
        dfs(res, list, root.left, sum - root.val);
        dfs(res, list, root.right, sum - root.val);
        list.remove(list.size() - 1);
    }
}