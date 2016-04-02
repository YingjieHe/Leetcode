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
    private int count=0;
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return count;
    }
    public boolean helper(TreeNode root)
    {
        if(root==null) return true;
        boolean left=helper(root.left);
        boolean right=helper(root.right);
        if(left&&right&&(root.left==null||root.val==root.left.val)&&(root.right==null||root.val==root.right.val))
        {
            count++;
            return true;
        }
        return false;
    }
}