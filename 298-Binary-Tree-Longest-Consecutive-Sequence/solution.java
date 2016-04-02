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
    
    public int longest = 0;
    
    public int longestConsecutive(TreeNode root) {
        DFS(root);
        return longest;
    }
    
    public int DFS(TreeNode root){
        if(root == null) return 0;
        
        int res = 1;
        int left = DFS(root.left);
        if(root.left != null && root.val == (root.left.val-1)) res += left;
        int right = DFS(root.right);
        if(root.right != null && root.val == (root.right.val-1)) res = Math.max(right+1, res);
        
        longest = Math.max(res, longest);
        
        return res;        
    }
}