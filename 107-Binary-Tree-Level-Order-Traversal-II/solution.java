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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root == null) return res;
        Queue<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        while(!list.isEmpty()){
            int size = list.size();
            List<Integer> l = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode temp = list.remove();
                l.add(temp.val);
                if(temp.left != null) list.add(temp.left);
                if(temp.right != null) list.add(temp.right);
            }
            res.add(0, new ArrayList<Integer>(l));
        }
        return res;
    }
}