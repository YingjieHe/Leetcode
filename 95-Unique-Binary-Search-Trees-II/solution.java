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
    public List<TreeNode> generateTrees(int n) {
        if(n <= 0) return  new ArrayList<TreeNode>();
        return getTree(1, n);
    }
    
    private List<TreeNode> getTree(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if(start > end) {
            list.add(null);
            return list;
        }
        for(int i = start; i <= end; i++) {
            List<TreeNode> left = getTree(start, i - 1);
            List<TreeNode> right = getTree(i + 1, end);
            for(TreeNode nodeLeft : left) {
                for(TreeNode nodeRight : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = nodeLeft;
                    node.right = nodeRight;
                    list.add(node);
                }
            }
        }
        return list;
    }
}