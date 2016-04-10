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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null) return res;
        dfs(res, root, "");
        return res;
    }
    public void dfs(List<String> res, TreeNode root, String s){
        if(root.left == null && root.right == null) {
            res.add(s + root.val);
            return;
        }
        if(root.left != null) dfs(res, root.left, s + root.val + "->");
        if(root.right != null) dfs(res, root.right, s + root.val + "->");
    }
}