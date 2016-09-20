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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode dfs(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if(ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int i;
        for(i = is; i < ie; i++) {
            if(inorder[i] == preorder[ps]) break;
        }
        root.left = dfs(preorder, ps + 1, ps + i -is, inorder, is, i - 1);
        root.right = dfs(preorder, ps + i -is + 1, pe, inorder, i + 1, ie);
        return root;
    }
}