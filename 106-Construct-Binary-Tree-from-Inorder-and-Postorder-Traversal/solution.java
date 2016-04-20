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
        return dfs(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    public TreeNode dfs(int[] in, int[] post, int is, int ie, int ps, int pe){
        if(ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(post[pe]);
        int index = 0;
        for(int i = is; i <= ie; i++){
            if(in[i] == post[pe]){
                index = i;
                break;
            }
        }
        root.left = dfs(in, post, is, index - 1, ps, ps + index - 1 - is);
        root.right = dfs(in, post, index + 1, ie, pe + index - ie, pe - 1);
        return root;
    }
}