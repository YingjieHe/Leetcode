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
    public boolean isSymmetric(TreeNode root) {
        return root == null || dfs(root.left, root.right);
    }
    public boolean dfs(TreeNode left, TreeNode right){
        if(left == null || right == null) return left == right;
        if(right.val != left.val) return false;
        return dfs(right.right, left.left) && dfs(left.right, right.left);
    }
}