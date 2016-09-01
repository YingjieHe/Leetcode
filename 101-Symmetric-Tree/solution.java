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
        if(root == null || (root.left == null && root.right == null)) return true;
        if(root.left == null || root.right == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while(!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left.val != right.val) return false;
            if(left.left != null && right.right != null) {
                q.offer(left.left);
                q.offer(right.right);
            }
            else if(left.left == null ^ right.right == null) return false;
            if(left.right != null && right.left != null) {
                q.offer(left.right);
                q.offer(right.left);
            }
            else if(left.right == null ^ right.left == null) return false;
        }
        return true;
    }
}