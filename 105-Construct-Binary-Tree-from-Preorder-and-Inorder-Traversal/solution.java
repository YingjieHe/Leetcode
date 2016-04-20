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
        return dfs(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
    }
    public TreeNode dfs(int[] in, int[] pre, int is, int ie, int ps, int pe){
        if(ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(pre[ps]);
        int index = 0;
        for(int i = is; i <= ie; i++){
            if(in[i] == pre[ps]){
                index = i;
                break;
            }
        }
        root.left = dfs(in, pre, is, index - 1, ps + 1, ps + index - is);
        root.right = dfs(in, pre, index + 1, ie, pe + index - ie + 1, pe);
        return root;
    }
}