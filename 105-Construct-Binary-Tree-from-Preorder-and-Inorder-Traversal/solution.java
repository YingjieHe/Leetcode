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
    
    private TreeNode dfs(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if(ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int index = 0;
        for(int i = is; i <= ie; i++) {
            if(preorder[ps] == inorder[i]) {
                index = i;
                break;
            }
        }
        root.left = dfs(preorder, ps + 1, ps + index - is, inorder, is, index - 1);
        root.right = dfs(preorder, ps + index - is + 1, pe, inorder, index + 1, ie);
        return root;
    }
}