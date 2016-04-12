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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        rightview(root, res, 0);
        return res;
    }
    public void rightview(TreeNode root, List<Integer> res, int depth){
        if(root == null) return;
        if(res.size() == depth) res.add(root.val);
        rightview(root.right, res, depth + 1);
        rightview(root.left, res, depth + 1);
    }
}