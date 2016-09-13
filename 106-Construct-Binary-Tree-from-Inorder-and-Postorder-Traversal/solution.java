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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode dfs(int[] postorder, int ps, int pe, int[] inorder, int is, int ie) {
        if(ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int i = is;
        for(; i <= ie; i++) {
            if(inorder[i] == postorder[pe]) break;
        }
        root.left = dfs(postorder, ps, ps + i - is - 1, inorder, is, i - 1);
        root.right = dfs(postorder, ps + i - is, pe - 1, inorder, i + 1, ie);
        return root;
    }
}