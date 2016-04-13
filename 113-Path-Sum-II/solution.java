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
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, list, res, sum);
        return res;
    }
    public void dfs(TreeNode root, List<Integer> list, List<List<Integer>> res, int sum){
        if(root == null) return;
        list.add(root.val);
        if(root.left == null && root.right == null && sum - root.val == 0){
            res.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
            return;
        }
        dfs(root.left, list, res, sum - root.val);
        dfs(root.right, list, res, sum - root.val);
        list.remove(list.size() - 1);
    }
}